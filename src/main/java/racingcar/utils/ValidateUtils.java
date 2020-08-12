package racingcar.utils;

public class ValidateUtils {
    public static String[] validateCarsName(String carsName) {
        String[] carsArray = carsName.split(",");
        for(String carName : carsArray) {
            validateCarName(carName);
        }
        return carsArray;
    }

    private static void validateCarName(String carName) {
        if(carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자 이상 5자 이하여야 합니다");
        }
    }
}
