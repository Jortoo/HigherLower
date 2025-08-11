package org.example;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YmlHandler {

    private static String path = "C:\\Users\\jqrto\\IdeaProjects\\OOPTesting\\target\\Data.yml";

    public static void putYmlData(String key, int value) throws IOException {

        Yaml ymlFile = new Yaml();

        Map<String, Object> data = getYmlData();
        if (data == null) {
            data = new HashMap<>();
        }

        data.put(key, value);

        try (FileWriter writer = new FileWriter(path)) {
            ymlFile.dump(data, writer);
        }
    }

    private static Map<String, Object> getYmlData() {

        Yaml ymlFile = new Yaml();

        try (FileReader reader = new FileReader(path)) {

            Map<String, Object> data = ymlFile.load(reader);
            ymlFile.dump(data);
            return data;

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }

    }

    public static int getStat(String key, int defaultValue) {

        if (YmlHandler.getYmlData().get(key) == null) {

            try {
                YmlHandler.putYmlData(key, defaultValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return (Integer) YmlHandler.getYmlData().get(key);
    }

}
