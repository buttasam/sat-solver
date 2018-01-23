package app;

import org.junit.Test;
import solver.SimulatedAnnealingSolver;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
public class SolverInfoTest {


    @Test
    public void runningTime() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        long time = solverInfo.runningTime(new SimulatedAnnealingSolver(), "/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_10_15_100.txt");
        System.out.println(time);
    }


}