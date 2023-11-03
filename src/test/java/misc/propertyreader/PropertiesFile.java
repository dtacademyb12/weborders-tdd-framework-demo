package misc.propertyreader;

import utils.ConfigReader;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new FileReader("config.properties"));
        Properties properties = new Properties();
        properties.load(bufferedReader);
        String url = properties.getProperty("url");
        System.out.println(url);
        System.out.println(properties.getProperty("implicit.wait"));
        System.out.println(properties.getProperty("explicit.wait"));

        System.out.println(ConfigReader.getProperty("implicit.wait"));

        String property = ConfigReader.getProperty("url");

        System.out.println(property);



    }
}
