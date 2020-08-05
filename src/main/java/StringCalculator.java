public class StringCalculator {

    public static int calculate(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException();
        }

        String[] stringArray = input.split(" ");

        int result = Integer.parseInt(stringArray[0]);

        for (int i = 1; i < stringArray.length; i = i + 2) {
            String operator = stringArray[i];
            int operand = Integer.parseInt(stringArray[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    result /= operand;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result;
    }
}
