package racingcar;

public class RacingCarView {

    private static final String LOCATION_PRINT_LETTER = "-";

    public static void printRacingCar(int location) {
        System.out.println(LOCATION_PRINT_LETTER.repeat(location));
    }

    public static void printMessage() {
        System.out.println("실행 결과");
    }
}
