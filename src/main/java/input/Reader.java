package input;

import entity.Configuration;

/**
 * @author Samuel Butta
 */
public interface Reader {


    public Configuration readInstance(String filePath);

}
