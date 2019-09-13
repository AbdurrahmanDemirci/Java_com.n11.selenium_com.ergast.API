package FunctionalTestingTestSuites.Utils.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import static FunctionalTestingTestSuites.Constant.Constants.N11_ERR;

public class N11PropertyUtils {

    private static final Logger logger = Logger.getLogger(N11PropertyUtils.class);
    public static Properties properties;

    public static void loadProperties() {

        try {

            properties = new Properties();
            File file = new File("./config/project.properties");
            FileReader reader = new FileReader(file);
            properties.load(reader);
            Properties props = new Properties();
            props.load(new FileInputStream("./config/log4j.properties"));
            PropertyConfigurator.configure(props);
        } catch (Exception e) {
            logger.error(N11_ERR + "Load Properties Failure|Reason: " + ExceptionUtils.getMessage(e));
        }
    }

    /**
     * @param data
     * @return
     */

    public static String getProperties(String data) {

        final String property = properties.getProperty(data);
        return property;
    }
}

