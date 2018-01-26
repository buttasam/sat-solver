package solver;

import entity.Formula;
import entity.Result;
import input.ReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
public class SimulatedAnnealingSolverTest {
    @Test
    public void solve() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_10_15_100.txt");

        SimulatedAnnealingSolver solver = new SimulatedAnnealingSolver();
        Result result = solver.solve(formula);

        System.out.println(result.getBestWeight());
    }

    @Test
    public void solve_25_40_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_25_40_100.txt");

        SimulatedAnnealingSolver solver = new SimulatedAnnealingSolver();
        Result result = solver.solve(formula);

        System.out.println(result.getBestWeight());
    }


    @Test
    public void solve_100_500_100() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/script/200/data/1");

        SimulatedAnnealingSolver solver = new SimulatedAnnealingSolver(350, 65, 0.85, 200 * 5);
        Result result = solver.solve(formula);
        System.out.println(result.getBestWeight());
    }


}