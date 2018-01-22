package input;

import entity.Formula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Samuel Butta
 */
public class ReaderImpl implements Reader {


    @Override
    public Formula readInstance(String filePath) throws IOException {
        Formula formula = new Formula();
        Files.lines(Paths.get(filePath)).forEach(l -> processLine(l, formula));

        return formula;
    }


    private void processLine(String line, Formula formula) {
        if (!isComment(line)) {
            switch (line.charAt(0)) {
                case 'p':
                    processConfInfo(line, formula);
                    break;
                case 'w':
                    processValues(line, formula);
                    break;
                default:
                    processClause(line, formula);
                    break;
            }
        }
    }


    /**
     * Očekávaný formát "p cnf 20 30"
     */
    private void processConfInfo(String line, Formula formula) {
        String[] split = line.split(" ");

        formula.setVariablesCount(Integer.parseInt(split[2]));
        formula.setClausesCount(Integer.parseInt(split[3]));
    }

    private void processValues(String line, Formula formula) {
        String[] split = line.split(" ");

        for (int i = 1; i < split.length; i++) {
            formula.addVariable(i, Integer.parseInt(split[i]));
        }
    }

    /**
     * Očekávaný vstup 17 18 -20 0
     */
    private void processClause(String line, Formula formula) {
        String[] split = line.split(" ");

        formula.addClause(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private boolean isComment(String line) {
        return line.startsWith("c");
    }

}
