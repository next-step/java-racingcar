package stringcalculator;

public class StringCalculator {
    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] values = input.split("[,:]");
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
}
