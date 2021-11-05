package racingcar.step3.validator;

public class CarValidator {

    public static final int COUNT_OF_CAR_MIN_NUM = 1;
    public static final int COUNT_OF_TRY_MIN_NUM = 1;

    public static void countOfCarCheck(int countOfCar) {
        if (countOfCar < COUNT_OF_CAR_MIN_NUM) {
            throw new IllegalArgumentException("음수값은 불가능 합니다.");
        }
    }

    public static void countOfTryCheck(int countOfTry) {
        if (countOfTry < COUNT_OF_TRY_MIN_NUM) {
            throw new IllegalArgumentException("음수값은 불가능 합니다.");
        }
    }

}
