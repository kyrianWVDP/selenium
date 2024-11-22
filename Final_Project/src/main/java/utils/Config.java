package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Config {
    private static final String CONFIG_FILE = "src/main/resources/config.json";
    private static JSONObject config;

    static {
        try {
            JSONParser parser = new JSONParser();
            config = (JSONObject) parser.parse(new FileReader(CONFIG_FILE));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String get(String key) {
        return (String) config.get(key);
    }
}
