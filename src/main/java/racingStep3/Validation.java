package racingStep3;

import java.util.regex.Pattern;

public class Validation {

    private static final String pattern = "^[0-9]*$";

    public static void numberCheck(String inputData) {
        if(!Pattern.matches(pattern, inputData)) {
            throw new NumberFormatException("숫자만 입력 할 수 있습니다!!!!");
        }
    }

    public static void validInputData(String inputData) {

        if(inputData.trim().isEmpty() || inputData == null) {
            throw new IllegalArgumentException("빈 값과 NULL은 입력 하실 수 없습니다!!!!!");
        }

        if(Integer.parseInt(inputData) < 1) {
            throw new IllegalArgumentException("시도 회수는 0 보다 커야 합니다.");
        }
    }

}
