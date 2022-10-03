package racingcar;

public class RacingCarView {

    private static final String LOCATION_PRINT_LETTER = "-";

    public static void printRacingCar(Car car) {
        System.out.println(LOCATION_PRINT_LETTER.repeat(car.getLocation()));
    }
}
