package com.itacademy.utils;

import com.itacademy.enums.PropertiesValue;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public static String getProperty(PropertiesValue property){
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/resources/configuration.properties");
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found");;
        } catch (IOException e){
            throw new RuntimeException();
        };

        for (Object key : properties.keySet()) {
            String systemValue = System.getProperty((String) key);
            if (!StringUtils.isEmpty(systemValue)) {
                properties.put(key, systemValue);
            }
        }

        return properties.getProperty(property.getKey(), property.getDefaultValue());
    }
}
