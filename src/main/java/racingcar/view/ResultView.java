package racingcar;

import java.util.List;

public class ResultView {

    private static final String SPLITTER = " : ";
    private static final String DASH = "-";

    public void openResults(Racing racing) {
        List<Car> cars = racing.getRacingCars();
        for (Car car : cars) {
            openIndividualResult(car);
        }
        System.out.println();
    }

    private static void openIndividualResult(Car car) {
        System.out.print(car.getCarName() + SPLITTER);
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
