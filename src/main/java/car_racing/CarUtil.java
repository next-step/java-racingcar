package car_racing;

public class CarUtil {
    private static final int MAX_CAR_NAME = 5;

    public static boolean isExceed5Characters(String carName) {
        return carName.length() > MAX_CAR_NAME;
    }
}
