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


            if (val.equals(Sign.ADD.getSign())) {
                num = Calculator.add(num, Integer.valueOf(inputStr[i + 1]));
            }

            if (val.equals(Sign.SUBTRACT.getSign())) {
                num = Calculator.subtract(num, Integer.valueOf(inputStr[i + 1]));
            }

            if (val.equals(Sign.MULTIPLY.getSign())) {
                num = Calculator.multiply(num, Integer.valueOf(inputStr[i + 1]));
            }

            if (val.equals(Sign.DIVISION.getSign())) {
                num = Calculator.division(num, Integer.valueOf(inputStr[i + 1]));
            }

        }

        return num;

    }

}
