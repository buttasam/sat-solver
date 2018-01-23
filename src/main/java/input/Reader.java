package input;

import entity.Formula;
import entity.Result;

import java.io.IOException;

/**
 * @author Samuel Butta
 */
public interface Reader {


    public Formula readInstance(String filePath) throws IOException;

    public Result readResult(String filePath) throws IOException;

}
