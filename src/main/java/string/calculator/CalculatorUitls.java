package string.calculator;


public class CalculatorUitls {

    public static boolean isNumeric(String input) {
        boolean numeric = true;

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            numeric = false;
        }

        return numeric;
    }
}
