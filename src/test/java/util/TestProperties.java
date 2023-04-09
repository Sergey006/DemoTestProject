package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            properties.load(Files.newInputStream(new File("./application.properties").toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
}
