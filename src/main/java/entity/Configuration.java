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
     * Pole proměnných
     */
    private int[] variables;


    /**
     * Pole klauzulí (tedy celá formule)
     */
    private Clause[] clauses;

    /**
     * Pomocné proměnné
     */
    private int tmpClausesIndex = 1;


    public void addClause(int x1, int x2, int x3) {
        if (clauses == null) {
            clauses = new Clause[clausesCount + 1];
        }
        clauses[tmpClausesIndex] = new Clause(x1, x2, x3);
        tmpClausesIndex++;
    }


    public void addVariable(int position, int value) {
        if (variables == null) {
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
