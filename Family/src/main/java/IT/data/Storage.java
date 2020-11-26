package IT.data;

import java.io.File;

/**
 * @author MJ
 */
public class Storage {

    protected static final String PATH =
            System.getProperty("user.home")
                    + File.separator + "Desktop"
                    + File.separator + "IT";
    protected static final String JSON_PATH = PATH + File.separator + "Jsons";
    protected static final String XML_PATH = PATH + File.separator + "XMLs";
    protected static final String PROJECT_URL = "https://edison.fel.zcu.cz/html/IT-names.html";
    protected static final String CSV_NAME = "persons.csv";
}
