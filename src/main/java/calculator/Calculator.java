package calculator;

public class Calculator {

    public static String[] parse(String text) {
        return text.split(":|,");
    }
}
