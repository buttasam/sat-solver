package input;

import entity.Configuration;

import java.io.IOException;

/**
 * @author Samuel Butta
 */
public interface Reader {


    public Configuration readInstance(String filePath) throws IOException;

}
