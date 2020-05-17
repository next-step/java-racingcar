package step2;

public class CalculatorUtils {
    public static String DELIMITER = " ";
    private static String OPERATOR_VALIDATE_REX = "[+\\-*/]";

    private CalculatorUtils() {
    }

    public static void inputValidator(String input) {
        blankCheck(input);

        String[] splitArr = input.split(DELIMITER);
        syntaxCheck(splitArr);

        for (int i = 0; i < splitArr.length; i++) {
            String str = splitArr[i];

            if (!isNumber(str)) {       // 숫자가 아니면 연산기호인지 확인
                operatorValidCheck(str);
            }
        }
    }

    private static void blankCheck(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void syntaxCheck(String[] splitArr) {
        int splitArrSize = splitArr.length;

        if (splitArrSize % 2 != 1) { // 배열의 길이 홀수인지 확인
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < splitArr.length; i += 2) {
            try {
                if (i == 1) {
                    isNumber(splitArr[0]);
                }

                operatorValidCheck(splitArr[i]);
                isNumber(splitArr[i+1]);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void operatorValidCheck(String op) {
        if (!op.matches(OPERATOR_VALIDATE_REX)) {
            throw new IllegalArgumentException();
        }
    }
}
