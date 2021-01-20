package caculator;

public class Converter {
    public static double toDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
    }
}
