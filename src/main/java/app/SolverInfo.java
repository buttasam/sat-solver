package app;

import entity.Formula;
import entity.Result;
import input.ReaderImpl;
import solver.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public double averageRunningTime(Solver solver, String inputDirectory) throws IOException {
        long[] times = Files.list(Paths.get(inputDirectory)).map(f -> {
            try {
                return runningTime(solver, f.toString());
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }).mapToLong(l -> l.longValue()).toArray();

        long sum = sumLongArray(times);
        int count = times.length;

        return (double) sum / count;
    }

    private long sumLongArray(long[] array) {
        int sum = 0;
        for (long l: array) {
            sum += l;
        }
        return sum;
    }

}
