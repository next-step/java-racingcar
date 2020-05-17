package step2;

public class CalculatorUtils {
    public static String DELIMITER = " ";
    private static String OPERATOR_VALIDATE_REX = "[+\\-*/]";

    public static void inputValidator(String input) {
        isBlank(input);

        String[] splitArr = input.split(DELIMITER);
        for(int i=0; i<splitArr.length; i++) {
            String str = splitArr[i];

            if(!isNumber(str)){       // 숫자가 아니면 연산기호인지 확인
                isValidOperator(str);
            }
        }
    }

    private static void isBlank(String str) {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
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

    private static void isValidOperator(String op) {
        if(!op.matches(OPERATOR_VALIDATE_REX)) {
            throw new IllegalArgumentException();
        }
    }
}