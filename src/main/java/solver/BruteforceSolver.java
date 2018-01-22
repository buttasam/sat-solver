package solver;

import entity.Formula;
import entity.Result;
import entity.Solution;

/**
 * @author Samuel Butta
 */
public class BruteforceSolver implements Solver {


    private int bestRating[];
    private int bestWeight;


    @Override
    public Result solve(Formula formula) {

        for(int i = 0; i < 10; i++) {
            Solution solution = new Solution(formula);
            solution.setRandomRating();

            System.out.print(solution.evaluateIsTrue() + " | ");
            for(int j = 1; j < solution.getRating().length; j++) {
                System.out.print(solution.getRating()[j]);
            }

            System.out.println(" | " + solution.evaluateWeight());


            //System.out.println(solution.getRating());
        }


        return null;
    }


}
