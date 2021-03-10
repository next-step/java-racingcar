package step2;

public class Validator {

    private Validator() {
    }

    public static void isEmptyOrIsBlankOrIsNull(String input) {
        // 공백 또는 빈 문자열, NULL, null 이라면 예외 발생
        if (!ValidatorEnum.notOperationAndThrow(input).equals(ValidatorEnum.OK)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isCheckOperation(String[] input) {
        for (int i = 1; i < input.length; i+=2) {
            // enum에 정의된 문자가 아니라면 에러 발생
            if (OperationEnum.getOperationEnum(input[i]) == OperationEnum.NONE) {
                throw new IllegalArgumentException();
            }
        }
    }
}
