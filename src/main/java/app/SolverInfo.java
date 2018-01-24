package app;

import entity.Formula;
import entity.Result;
import input.ReaderImpl;
import solver.Solver;

import java.io.IOException;

/**
 * @author Samuel Butta
 */
public class SolverInfo {

    private ReaderImpl reader = new ReaderImpl();


    public long runningTime(Solver solver, String inputFile) throws IOException {
        Formula formula = reader.readInstance(inputFile);

        long startTime = System.currentTimeMillis();
        solver.solve(formula);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }


    public double error(Solver solver, String inputFile, String resultFile) throws IOException {
        Formula formula = reader.readInstance(inputFile);

        Result result = solver.solve(formula);
        Result expectedResult = reader.readResult(resultFile);

        return (double) (expectedResult.getBestWeight() - result.getBestWeight()) / expectedResult.getBestWeight();
    }

}
