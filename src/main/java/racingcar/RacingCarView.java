package racingcar;

import java.util.List;

public class RacingCarView {

    private static final String LOCATION_PRINT_LETTER = "-";

    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printRacingCar(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(LOCATION_PRINT_LETTER.repeat(car.getLocation()));
        }
    }
}
