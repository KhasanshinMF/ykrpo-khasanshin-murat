package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class Settings {
    private static String baseUrl;
    private static String login;
    private static String password;

    private static Document document;

    static {
        try {
            InputStream stream =
                    Settings.class
                            .getClassLoader()
                            .getResourceAsStream("settings.xml");
            if (stream == null) {
                throw new RuntimeException("settings.xml not found");
            }
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(stream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            Node node =
                    document.getDocumentElement()
                            .getElementsByTagName("baseUrl")
                            .item(0);
            baseUrl = node.getTextContent();
        }
        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            Node node =
                    document.getDocumentElement()
                            .getElementsByTagName("login")
                            .item(0);
            login = node.getTextContent();
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            Node node =
                    document.getDocumentElement()
                            .getElementsByTagName("password")
                            .item(0);
            password = node.getTextContent();
        }
        return password;
    }
}
