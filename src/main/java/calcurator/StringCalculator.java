package calcurator;


public class StringCalculator {

    public static int calculate(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] inputStr = input.split(" ");

        int num = Integer.valueOf(inputStr[0]);

        for (int i = 1; i < inputStr.length; i += 2) {

            String val = inputStr[i];

            if (!Calculator.isValidSign(val)) {
                throw new IllegalArgumentException();
            }
            if (inputStr[i].equals("+")) {
                num = Calculator.add(num, Integer.valueOf(inputStr[i + 1]));
            }

            if (inputStr[i].equals("-")) {
                num = Calculator.subtract(num, Integer.valueOf(inputStr[i + 1]));
            }

            if (inputStr[i].equals("*")) {
                num = Calculator.multiply(num, Integer.valueOf(inputStr[i + 1]));
            }

            if (inputStr[i].equals("/")) {
                num = Calculator.division(num, Integer.valueOf(inputStr[i + 1]));
            }

        }

        return num;

    }

}
