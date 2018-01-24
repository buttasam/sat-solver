package app;

import org.junit.Test;
import solver.SimulatedAnnealingSolver;

/**
 * @author Samuel Butta
 */
public class MeasureTest {


    @Test
    public void time_initTemperature() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(int i = 50; i <= 500; i += 50) {
            double avg = solverInfo.averageRunningTime(new SimulatedAnnealingSolver(i, 10, 0.9, 100), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }

    @Test
    public void error_initTemperature() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(int i = 50; i <= 500; i += 50) {
            double avg = solverInfo.averageErrorTime(new SimulatedAnnealingSolver(i, 10, 0.9, 100), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }


    @Test
    public void time_finalTemperature() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(int i = 50; i <= 500; i += 50) {
            double avg = solverInfo.averageRunningTime(new SimulatedAnnealingSolver(500, i, 0.9, 100), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }

    @Test
    public void error_finalTemperature() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(int i = 50; i <= 500; i += 50) {
            double avg = solverInfo.averageErrorTime(new SimulatedAnnealingSolver(500, i, 0.9, 100), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }

}