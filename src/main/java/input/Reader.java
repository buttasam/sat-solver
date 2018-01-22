package input;

import entity.Formula;

import java.io.IOException;

/**
 * @author Samuel Butta
 */
public interface Reader {


    public Formula readInstance(String filePath) throws IOException;

}
