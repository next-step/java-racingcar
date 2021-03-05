package cal;

public class StringCalculator {

    int calculate(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.contentEquals(" ")) {
            throw new IllegalArgumentException();
        }
        String[] tokenArray = input.split(" ");

        int result = Integer.parseInt(tokenArray[0]);

        int tokenArrayLength = tokenArray.length;
        for (int i = 1; i < tokenArrayLength; i += 2) {
            String sign = tokenArray[i];
            int number = Integer.parseInt(tokenArray[i + 1]);
            switch (sign) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return result;
    }
}
