package com.itacademy.enums;

public enum PropertiesValue {
    BROWSER ("browser", "chrome"),
    SELENIUM_URL("selenium_url", "http://localhost:4444");

    private String key;
    private String defaultValue;

    PropertiesValue(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
