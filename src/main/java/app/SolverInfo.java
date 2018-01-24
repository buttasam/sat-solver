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


    // Udává počet opakování výpočtu z kterého se následně vypočítá aritmetický průměr
    private static final int MEASURE_SIZE = 10;
    private ReaderImpl reader = new ReaderImpl();


    public double runningTime(Solver solver, String inputFile, int measureSize) throws IOException {
        Formula formula = reader.readInstance(inputFile);

        double runningTimeSum = 0;
        for (int i = 0; i < measureSize; i++) {
            long startTime = System.currentTimeMillis();
            solver.solve(formula);
            long endTime = System.currentTimeMillis();
            runningTimeSum += (endTime - startTime);
        }

        return runningTimeSum / measureSize;
    }


    public double error(Solver solver, String inputFile, String resultFile, int measureSize) throws IOException {
        Formula formula = reader.readInstance(inputFile);
        Result expectedResult = reader.readResult(resultFile);

        double errorSum = 0;
        for (int i = 0; i < measureSize; i++) {
            Result result = solver.solve(formula);
            errorSum += (double) (expectedResult.getBestWeight() - result.getBestWeight()) / expectedResult.getBestWeight();
        }

        return errorSum / measureSize;
    }

    public double averageRunningTime(Solver solver, String inputDirectory) throws IOException {
        long[] times = Files.list(Paths.get(inputDirectory)).map(f -> {
            try {
                return runningTime(solver, f.toString(), MEASURE_SIZE);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }).mapToLong(l -> l.longValue()).toArray();

        long sum = sumLongArray(times);
        int count = times.length;

        return (double) sum / count;
    }


    public double averageErrorTime(Solver solver, String inputDirectory) throws IOException {
        double[] errors = Files.list(Paths.get(inputDirectory)).map(f -> {
            try {
                String resultFile = f.toString().replaceFirst("data", "result");
                double error = error(solver, f.toString(), resultFile, MEASURE_SIZE);
                return error;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }).mapToDouble(d -> d.doubleValue()).toArray();

        double sum = sumDoubleArray(errors);
        int count = errors.length;

        return sum / count;
    }


    private long sumLongArray(long[] array) {
        long sum = 0;
        for (long l : array) {
            sum += l;
        }
        return sum;
    }

    private double sumDoubleArray(double[] array) {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum;
    }

}
