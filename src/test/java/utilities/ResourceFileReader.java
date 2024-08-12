package utilities;

import config.BaseConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ResourceFileReader {
    JSONObject jsonObject;
    BaseConfig baseConfig = new BaseConfig();
    JSONParser parser = new JSONParser();
    String resourcePackagePath = "src/test/resources/validations/";

    public String getValidationsData(String pageName, String key) {
        String filePath = resourcePackagePath + "validations.json";
        try {
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) ((JSONObject) obj).get(baseConfig.getLocale());
        } catch (IOException | ParseException var4) {
            throw new RuntimeException(var4);
        }
        JSONObject tempObj = (JSONObject) jsonObject.get(pageName);
        return (String) tempObj.get(key);
    }

}