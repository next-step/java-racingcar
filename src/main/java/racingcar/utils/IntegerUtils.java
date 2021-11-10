package racingcar.utils;

public interface IntegerUtils {

    String DEFAULT_MESSAGE = "0또는 음수값은 올 수 없어요.";

    static int isPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE);
        }
        return number;
    }

}
