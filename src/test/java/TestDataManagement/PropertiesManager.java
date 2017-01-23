package TestDataManagement;
/**
 * Created by Devin Penny on 1/4/17.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

//the purpose of this class is to grab data from a properties file that can be used for testing
//the output of this method is a hash map <String,String> that contains every parameter

public class PropertiesManager {

    public String parameterFilePath = ".//src/test/java/TestDataManagement/PropertiesFiles/AutomationProperties.properties";

    //public String parameterFilePath = "./PropertiesFiles/AutomationProperties.properties";

    public HashMap<String,String> testProperties = new HashMap<>();

    public HashMap<String,String> GetPropertiesData(){
        Properties data = new Properties();
        InputStream input;

        try{
            input = new FileInputStream(parameterFilePath);
            data.load(input);
            String strKey;
            String strVal;

            Set key = data.keySet();

            for (Object aKey : key) {
                strKey = (String) aKey;
                strVal = data.get(strKey).toString();
                System.out.println(strKey + ":" + strVal);
                testProperties.put(strKey, strVal);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return testProperties;
    }
}
