package cal;

public class StringCalculator {

    int calculateStringEquation(String input) {
        if (isNull(input) || isBlank(input)) {
            throw new IllegalArgumentException();
        }

        String[] tokenArray = input.split(" ");

        int result = Integer.parseInt(tokenArray[0]);

        int tokenArrayLength = tokenArray.length;
        for (int i = 1; i < tokenArrayLength; i += 2) {
            String sign = tokenArray[i];
            int number = Integer.parseInt(tokenArray[i + 1]);
            result = calculate(result, number, sign);
        }

        return result;
    }

    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isBlank(String input) {
        return input.trim().equals("");
    }

    private int calculate(int leftHand, int rightHand, String sign) {
        switch (sign) {
            case "+":
                return leftHand + rightHand;
            case "-":
                return leftHand - rightHand;
            case "*":
                return leftHand * rightHand;
            case "/":
                return leftHand / rightHand;
            default:
                throw new IllegalArgumentException();
        }
    }
}
