package racingcar;

import java.util.List;

public class ResultView {

    public void openResults(List<Car> cars) {
        for (Car car : cars) {
            openIndividualResult(car);
        }
        System.out.println();
    }

    private static void openIndividualResult(Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
