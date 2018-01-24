package app;

import org.junit.Test;
import solver.SimulatedAnnealingSolver;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
public class SolverInfoTest {

    @Test
    public void averageRunningTime() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/5/data";
        double avg = solverInfo.averageRunningTime(new SimulatedAnnealingSolver(), inputDirectory);

        System.out.println(avg);
    }

    @Test
    public void error_25_40() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputFile = "/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_25_40_100.txt";
        String resultFile = "/home/samik/IdeaProjects/sat-solver/src/test/resources/result/sat_25_40_100.txt";
        double error = solverInfo.error(new SimulatedAnnealingSolver(), inputFile, resultFile);
        System.out.println(error);
    }

    @Test
    public void error_3_3_100() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputFile = "/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_3_3_100.txt";
        String resultFile = "/home/samik/IdeaProjects/sat-solver/src/test/resources/result/sat_3_3_100.txt";
        double error = solverInfo.error(new SimulatedAnnealingSolver(), inputFile, resultFile);
        System.out.println(error);
    }


    @Test
    public void runningTime() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        long time = solverInfo.runningTime(new SimulatedAnnealingSolver(), "/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_10_15_100.txt");
        System.out.println(time);
    }


}