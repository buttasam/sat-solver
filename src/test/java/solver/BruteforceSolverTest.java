package solver;

import entity.Formula;
import input.ReaderImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
public class BruteforceSolverTest {


    @Test
    public void solve() throws Exception {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/main/resources/data/sat_4_4_100.txt");

        BruteforceSolver solver = new BruteforceSolver();
        solver.solve(formula);
    }

}