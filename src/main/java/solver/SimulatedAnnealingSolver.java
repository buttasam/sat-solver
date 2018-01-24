package solver;

import entity.Formula;
import entity.Result;
import entity.Solution;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.SerializationUtils;

/**
 * @author Samuel Butta
 */
public class SimulatedAnnealingSolver implements Solver {


    /**
     * Parametry
     */
    private final double INIT_TEMPERATURE;
    private final double FINAL_TEMP;
    private final double COOLING_CONSTANT;
    private final int STEPS;

    public SimulatedAnnealingSolver() {
        INIT_TEMPERATURE = 500;
        FINAL_TEMP = 10;
        COOLING_CONSTANT = 0.9;
        STEPS = 100;
    }

    public SimulatedAnnealingSolver(double INIT_TEMPERATURE, double FINAL_TEMP, double COOLING_CONSTANT, int STEPS) {
        this.INIT_TEMPERATURE = INIT_TEMPERATURE;
        this.FINAL_TEMP = FINAL_TEMP;
        this.COOLING_CONSTANT = COOLING_CONSTANT;
        this.STEPS = STEPS;
    }


    @Override
    public Result solve(Formula formula) {
        Solution oldSolution, newSolution;
        // nastavení počátečních hodnot
        double temperature = INIT_TEMPERATURE;
        // náhodné řešení
        oldSolution = new Solution(formula);
        oldSolution.setRandomTrueRating();

        int globalMax = oldSolution.evaluateWeight();

        while (!frozen(temperature)) {

            for (int i = 0; i < STEPS; i++) {
                newSolution = SerializationUtils.clone(oldSolution);
                newSolution.setNeighbourRating();
                //System.out.println(oldSolution + "(" + oldSolution.evaluateWeight() + ")" + " | " + newSolution + "(" + newSolution.evaluateWeight() + ")");

                oldSolution = acceptance(oldSolution, newSolution, temperature);

                if (oldSolution.evaluateIsTrue() && oldSolution.evaluateWeight() > globalMax) {
                    globalMax = oldSolution.evaluateWeight();
                }
            }

            // ochlazení teploty
            temperature = coolTemperature(temperature);
        }

        return new Result(globalMax);
    }

    private Solution acceptance(Solution oldSolution, Solution newSolution, double temperature) {
        int oldWeight = oldSolution.evaluateWeight();
        int newWeight = newSolution.evaluateWeight();

        boolean oldIsTrue = oldSolution.evaluateIsTrue();
        boolean newIsTrue = newSolution.evaluateIsTrue();
        //System.out.println(oldIsTrue + " " + newIsTrue);


        // přijetí lepšího řešení
        if ((!oldIsTrue && newIsTrue) ||
                ((oldIsTrue && newIsTrue) && (newWeight > oldWeight)) ||
                (!oldIsTrue && !newIsTrue && (newWeight > oldWeight))
                ) {
            return newSolution;
        }

        // přijetí horšího řešení
        double exponent = (oldWeight - newWeight) / temperature;
        double a = Math.exp((-1) * exponent);
        if (RandomUtils.nextDouble(0, 1) > a) {
            return newSolution;
        }


        return oldSolution;
    }

    private double coolTemperature(double temperature) {
        return temperature * COOLING_CONSTANT;
    }


    public boolean frozen(double temperature) {
        return (temperature < FINAL_TEMP);
    }

}
