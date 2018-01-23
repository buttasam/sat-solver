package solver;

import entity.Formula;
import entity.Result;
import input.ReaderImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Samuel Butta
 */
public class BruteforceSolverTest {


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