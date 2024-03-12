package racingCar.utils;

public class Utils {
    private static final int MAX_NAME_LEN = 5;

    public static int toInt(String values){
        return checkPositive(values);
    }

    private static int checkPositive(String value){
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력");
        }
        if (result < 0){
            throw new IllegalArgumentException("음수 입력");
        }
        return result;
    }

    public static void checkUsableName(String value){
        if (value.length() > MAX_NAME_LEN){
            throw new IllegalArgumentException("너무 긴 길이의 이름" + value);
        }
    }
}
