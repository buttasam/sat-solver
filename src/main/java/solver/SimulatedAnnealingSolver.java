package solver;

import entity.Formula;
import entity.Result;
import entity.Solution;
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
        INIT_TEMPERATURE = 200;
        FINAL_TEMP = 10;
        COOLING_CONSTANT = 0.8;
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
        oldSolution.setRandomRating();

        while (!frozen(temperature)) {

            for (int i = 0; i < STEPS; i++) {
                newSolution = SerializationUtils.clone(oldSolution);
                newSolution.setNeighbourRating();
                System.out.println(oldSolution + "(" + oldSolution.evaluateWeight() + ")" + " | " + newSolution + "(" + newSolution.evaluateWeight() + ")");

                oldSolution = acceptance(oldSolution, newSolution, temperature);
            }

            // ochlazení teploty
            temperature = coolTemperature(temperature);
        }

        return null;
    }

    private Solution acceptance(Solution oldSolution, Solution newSolution, double temperature) {
        // přijetí lepšího
        int oldWeight = oldSolution.evaluateWeight();
        int newWeight = newSolution.evaluateWeight();

        // TODO pravdivost formule
        if (newWeight > oldWeight) {
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
