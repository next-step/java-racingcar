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
    }

    private static void blankCheck(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력식이 비어있습니다.");
        }
    }

    private static void syntaxCheck(String[] splitArr) {
        int splitArrSize = splitArr.length;

        if (splitArrSize % 2 != 1) { // 배열의 길이 홀수인지 확인
            throw new IllegalArgumentException("입력식이 정상적이지 않습니다.");
        }

        for (int i = 1; i < splitArr.length; i += 2) {
            try {
                if (i == 1) {
                    numberCheck(splitArr[0]);
                }

                operatorValidCheck(splitArr[i]);
                numberCheck(splitArr[i+1]);
            } catch (Exception e) {
                throw new IllegalArgumentException("입력식이 정상적이지 않습니다.");
            }
        }
    }

    private static void numberCheck(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닌 값이 들어있습니다.");
        }
    }

    private static void operatorValidCheck(String op) {
        if (!op.matches(OPERATOR_VALIDATE_REX)) {
            throw new IllegalArgumentException("처리 불가능한 사칙연산 기호가 포함되어있습니다.");
        }
    }
}
