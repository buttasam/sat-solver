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
        solver.solve(formula);
    }

}