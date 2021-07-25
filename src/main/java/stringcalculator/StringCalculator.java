package stringcalculator;

public class StringCalculator {
    public int calculate(String input) {
        String[] args = input.split(" ");

        int result = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i += 2) {
            result += Integer.parseInt(args[i + 1]);
        }

        return result;
    }
}
