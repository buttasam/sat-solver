package solver;

import entity.Formula;
import entity.Result;
import input.ReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
public class BruteforceSolverTest {


    @Test
    public void solveAllFiles() throws Exception {

        String mainPath = "/home/samik/IdeaProjects/sat-solver/script/";

        for (int i = 5; i < 26; i += 2) {

            List<Path> files = Files.list(Paths.get(mainPath + i + "/data")).collect(Collectors.toList());
            for (Path file : files) {
                // řešení
                ReaderImpl reader = new ReaderImpl();
                Formula formula = reader.readInstance(mainPath + i + "/data/" + file.getFileName());
                BruteforceSolver solver = new BruteforceSolver();
                Result result = solver.solve(formula);

                // zapsani vysledku
                BufferedWriter out = new BufferedWriter(new FileWriter(mainPath + i + "/result/" + file.getFileName()));
                try {
                    out.write(result.getBestWeight() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    out.close();
                }
            }
        }
    }


    @Test
    public void solve_10_15_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_10_15_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        solver.solve(formula);

        Result result = solver.solve(formula);
        Assert.assertEquals(498, result.getBestWeight());
    }


    @Test
    public void solve_3_3_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_3_3_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);

        Assert.assertEquals(126, result.getBestWeight());
    }


    @Test
    public void solve_4_4_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_4_4_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);

        Assert.assertEquals(218, result.getBestWeight());
    }

    @Test
    public void solve_20_30_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_20_30_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);

        Assert.assertEquals(818, result.getBestWeight());
    }

    @Test
    public void solve_30_40_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_30_40_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);

    }

    @Test
    public void solve_20_40_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_20_40_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);
        System.out.println(result.getBestWeight());
    }

    @Test
    public void solve_22_40_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_22_40_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);
        System.out.println(result.getBestWeight());
    }

    @Test
    public void solve_25_40_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_25_40_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        Result result = solver.solve(formula);
        System.out.println(result.getBestWeight());
    }


}