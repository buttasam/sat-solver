package input;

import entity.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Samuel Butta
 */
public class ReaderImpl implements Reader {


    @Override
    public Configuration readInstance(String filePath) throws IOException {
        Configuration configuration = new Configuration();
        Files.lines(Paths.get(filePath)).forEach(l -> processLine(l, configuration));

        return configuration;
    }


    private void processLine(String line, Configuration configuration) {
        if (!isComment(line)) {
            switch (line.charAt(0)) {
                case 'p':
                    processConfInfo(line, configuration);
                    break;
                case 'w':
                    processValues(line, configuration);
                    break;
                default:
                    processClause(line, configuration);
                    break;
            }
        }
    }


    /**
     * Očekávaný formát "p cnf 20 30"
     */
    private void processConfInfo(String line, Configuration configuration) {
        String[] split = line.split(" ");

        configuration.setVariablesCount(Integer.parseInt(split[2]));
        configuration.setClausesCount(Integer.parseInt(split[3]));
    }

    private void processValues(String line, Configuration configuration) {
        String[] split = line.split(" ");

        for (int i = 1; i < split.length; i++) {
            configuration.addVariable(i, Integer.parseInt(split[i]));
        }
    }

    /**
     * Očekávaný vstup 17 18 -20 0
     */
    private void processClause(String line, Configuration configuration) {
        String[] split = line.split(" ");

        configuration.addClause(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private boolean isComment(String line) {
        return line.startsWith("c");
    }

}
