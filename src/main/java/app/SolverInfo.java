package app;

import entity.Formula;
import input.ReaderImpl;
import solver.Solver;

import java.io.IOException;

/**
 * @author Samuel Butta
 */
public class SolverInfo {

    public long runningTime(Solver solver, String inputFile) throws IOException {
        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance(inputFile);

        long startTime = System.currentTimeMillis();
        solver.solve(formula);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }


}
