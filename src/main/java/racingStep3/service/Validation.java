package racingStep3.service;

import racingStep3.domain.Position;

import java.util.regex.Pattern;

public class Validation {

    private static final String PATTERN = "^[0-9]*$";
    private static final int TRYMINCOUNT = 1;
    private static final int LOCATIONMIN = 0;


    public static void numberCheck(String inputData) {
        if(!Pattern.matches(PATTERN, inputData)) {
            throw new NumberFormatException("숫자만 입력 할 수 있습니다!!!!");
        }
    }

    public static void validInputData(String inputData) {

        if(inputData.trim().isEmpty() || inputData == null) {
            throw new IllegalArgumentException("빈 값과 NULL은 입력 하실 수 없습니다!!!!!");
        }

        if(Integer.parseInt(inputData) < TRYMINCOUNT) {
            throw new IllegalArgumentException("시도 회수는 0 보다 커야 합니다.");
        }
    }

    public static void validCarsCount(int count) {
        if(count < TRYMINCOUNT) {
            throw new IllegalArgumentException("적어도 1대 이상의 자동차가 필요합니다!!!!");
        }
    }

    public static void checkMinSize(int location) {
        if(location < LOCATIONMIN) {
            throw new IllegalArgumentException("음의 정수인 위치는 없습니다!!!");
        }
    }

    public static void nullCheck(Position position) {
        if(position == null) {
            throw new NullPointerException("Null 값은 생성 할 수 없습니다.");
        }
    }
}
