package entity;


import java.util.Random;

/**
 * @author Samuel Butta
 */
public class Solution {

    /**
     * Ohodnocení proměnných
     */
    private boolean[] rating;


    private Formula formula;

    public Solution(Formula formula) {
        this.formula = formula;
        rating = new boolean[formula.getVariablesCount() + 1];
    }

    public void setRandomRating() {
        Random random = new Random();
        for (int i = 1; i <= formula.getVariablesCount(); i++) {
            if (random.nextInt() % 2 == 0) {
                rating[i] = true;
            }
        }
    }

    public boolean[] getRating() {
        return rating;
    }


    public int evaluateWeight() {
        int weight = 0;
        for(int i = 1; i <= formula.getVariablesCount(); i++) {
            if(rating[i]) {
                weight += formula.getVariables()[i];
            }
        }

        return weight;
    }

    public boolean evaluateIsTrue() {
        for (int i = 1; i <= formula.getClausesCount(); i++) {
            Clause clause = formula.getClauses()[i];
            if(!evaluateClauseIsTrue(clause)) {
                return false;
            }
        }

        return true;
    }

    public boolean evaluateClauseIsTrue(Clause clause) {
        int variable1 = clause.getX1();
        int variable2 = clause.getX2();
        int variable3 = clause.getX3();

        return isVariableTrueInClause(variable1) || isVariableTrueInClause(variable2) || isVariableTrueInClause(variable3);
    }

    private boolean isVariableTrueInClause(int variable) {
        if (variable > 0) {
            return rating[variable];
        } else {
            return !rating[(-1) * variable];
        }
    }
}
