package racingcar;

import java.util.StringJoiner;

public class RacingResultView {

    public static void viewResult(RacingCars cars) {
        for (Car car : cars.getRacingCars()) {
            printPosition(car);
        }
    }

    private static void printPosition(Car car) {
        int pos = car.getPosition();
        StringJoiner sj = new StringJoiner("");
        for (int i = 0; i < pos; i++) {
            sj.add("-");
        }
        System.out.println(sj.toString());
    }
}
