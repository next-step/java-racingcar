package racingcar.service.util;

import java.util.regex.Pattern;

public class Validation {

    private static final String PATTERN = "^[0-9]*$";
    private static final int TRY_MIN_COUNT = 1;
    private static final int LOCATION_MIN = 0;
    private static final int CAR_NAME_MAXIMUM_SIZE = 5;


    public static void numberCheck(String inputData) {
        if(!Pattern.matches(PATTERN, inputData)) {
            throw new NumberFormatException("숫자만 입력 할 수 있습니다!!!!");
        }
    }

    public static void validInputData(String inputData) {

        if(inputData.trim().isEmpty() || inputData == null) {
            throw new IllegalArgumentException("빈 값과 NULL은 입력 하실 수 없습니다!!!!!");
        }

        if(Integer.parseInt(inputData) < TRY_MIN_COUNT) {
            throw new IllegalArgumentException("시도 회수는 0 보다 커야 합니다.");
        }
    }

    public static void checkMinSize(int location) {
        if(location < LOCATION_MIN) {
            throw new IllegalArgumentException("음의 정수인 위치는 없습니다!!!");
        }
    }

    public static <T> void nullValueCheck(T reference) {
        if (reference == null) {
            throw new NullPointerException("Null 값은 생성 할 수 없습니다.");
        }
    }

    public static boolean nameSizeCheck(String carName) {
        if(carName.length() > CAR_NAME_MAXIMUM_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다!!!");
        }

        return true;
    }
}
