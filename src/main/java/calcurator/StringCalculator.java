package calcurator;


public class StringCalculator {

    public static int calculate(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] inputStr = input.split(" ");

        int num = Integer.valueOf(inputStr[0]);

        for (int i = 1; i < inputStr.length; i += 2) {

            String operation = inputStr[i];
            num = Calculator.calculate(operation, num, Integer.valueOf(inputStr[i + 1]));
        }

        return num;

    }

}
