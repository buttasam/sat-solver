package entity;

import java.util.List;

/**
 * Hlavní třída reprezentuje instanci SAT problému.
 *
 * @author Samuel Butta
 */
public class Configuration {

    /**
     * Počet proměnných
     */
    private int variablesCount;

    /**
     * Počet klauzulí
     */
    private int clausesCount;


    /**
     * Zadaná formule
     */
    private Formula formula;

    private int[] variables;


    public void addVariable(int position, int value) {
        if(variables == null) {
            variables = new int[variablesCount + 1]; // cislovani (indexovani) zacina od 1
        }

        variables[position] = value;
    }

    public int getVariablesCount() {
        return variablesCount;
    }

    public void setVariablesCount(int variablesCount) {
        this.variablesCount = variablesCount;
    }

    public int getClausesCount() {
        return clausesCount;
    }

    public void setClausesCount(int clausesCount) {
        this.clausesCount = clausesCount;
    }
}
