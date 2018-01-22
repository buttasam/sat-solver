package solver;

import entity.Formula;
import entity.Result;
import entity.Solution;

/**
 * @author Samuel Butta
 */
public class BruteforceSolver implements Solver {


    @Override
    public Result solve(Formula formula) {
        int bestWeight = 0;

        Solution solution = new Solution(formula);

        boolean[] tmpRating = new boolean[formula.getVariablesCount() + 1];

        /**
         * vytvoreni vsech permutaci
         *
         * zdroj: http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
         */
        for (long i = 0; i < ((long) 1 << formula.getVariablesCount()); i++) {
            int tmpRatingIndex = 1;
            for (int j = 0; j < formula.getVariablesCount(); j++) {
                tmpRating[tmpRatingIndex] = ((i & (1 << j)) > 0);
                //System.out.print(tmpRating[tmpRatingIndex] ? "1" : "0");
                tmpRatingIndex++;
            }
            //System.out.println("|" + solution.evaluateWeight());

            // vypočítání dané permutace
            bestWeight = calculateBestWeight(solution, tmpRating, bestWeight);
        }

        return new Result(bestWeight);
    }


    public int calculateBestWeight(Solution solution, boolean[] tmpRating, int bestWeight) {
        solution.setRating(tmpRating);
        if (solution.evaluateIsTrue()) {
            int evaluatedWeight = solution.evaluateWeight();
            if (evaluatedWeight > bestWeight) {
                bestWeight = evaluatedWeight;
            }
        }

        return bestWeight;
    }

}
