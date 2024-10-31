package br.com.vemser.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulation {

    private static Properties getProp() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/application.properties");
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String getNome() {
        return getProp().getProperty("nome");
    }

    public static String getLogin() {
        return getProp().getProperty("login");
    }

    public static String getPwd() {
        return getProp().getProperty("password");
    }

}
