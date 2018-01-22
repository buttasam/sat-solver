package solver;

import entity.Formula;
import entity.Result;

/**
 * @author Samuel Butta
 */
public interface Solver {


    public Result solve(Formula formula);

}
