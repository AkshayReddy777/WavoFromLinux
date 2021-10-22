package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BOUserLoginCreds {

    protected static Properties userLoginProperties;


    public static void initialize() {
        userLoginProperties = new Properties();

        File loginCredsFile = new File("/Users/ponni/WavoWebTestAutomation/src/test/java/testdata/UserLoginDetails");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(loginCredsFile);
            userLoginProperties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Interrupted. Check why.");
        }
    }

    public static String getBaseURL() { return userLoginProperties.getProperty("BaseURL"); }
    public static String getEmail() {
        return userLoginProperties.getProperty("BOUserEmail");
    }
    public static String getPassword() {
        return userLoginProperties.getProperty("BOUserPassword");
    }
}
