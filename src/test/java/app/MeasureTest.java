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


    @Test
    public void time_coolingConstant() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(double i = 0.1; i <= 0.9; i += 0.1) {
            double avg = solverInfo.averageRunningTime(new SimulatedAnnealingSolver(500, 10, i, 100), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }

    @Test
    public void error_coolingConstant() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(double i = 0.1; i <= 0.9; i += 0.1) {
            double avg = solverInfo.averageErrorTime(new SimulatedAnnealingSolver(500, 10, i, 100), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }


    @Test
    public void time_equilibrium() throws Exception {
        SolverInfo solverInfo = new SolverInfo();
        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(int i = 1; i <= 10; i ++) {
            double avg = solverInfo.averageRunningTime(new SimulatedAnnealingSolver(500, 10, 0.9, i * 40), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }


    @Test
    public void error_equilibrium() throws Exception {
        SolverInfo solverInfo = new SolverInfo();
        String inputDirectory = "/home/samik/IdeaProjects/sat-solver/script/25/data";

        for(int i = 1; i <= 10; i ++) {
            double avg = solverInfo.averageErrorTime(new SimulatedAnnealingSolver(500, 10, 0.9, i * 40), inputDirectory);
            System.out.println(i + "         " + avg);
        }
    }


    @Test
    public void final_time() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        for(int i = 5; i <= 25; i += 2) {
            double avg = solverInfo.averageRunningTime(new SimulatedAnnealingSolver(350, 65, 0.85, 40 * 8), "/home/samik/IdeaProjects/sat-solver/script/" + i + "/data");
            System.out.println(i + "         " + avg);
        }

    }



    @Test
    public void final_error() throws Exception {
        SolverInfo solverInfo = new SolverInfo();

        for(int i = 5; i <= 25; i += 2) {
            double avg = solverInfo.averageErrorTime(new SimulatedAnnealingSolver(350, 65, 0.85, 40 * 8), "/home/samik/IdeaProjects/sat-solver/script/" + i + "/data");
            System.out.println(i + "         " + avg);
        }

    }



}