package racingcar;

import java.util.List;

public class ResultView {

    public void displayResults(List<Car> cars) {
        int trialCount = cars.get(0).getTrialCount();

        for (int i = 0; i < trialCount; i++) {
            displayColumn(cars, i);
            System.out.println();
        }
    }

    private void displayColumn(List<Car> cars, int columnIndex) {
        for (Car car : cars) {
            System.out.println(getPositionLine(car, columnIndex));
        }
    }

    private String getPositionLine(Car car, int columnIndex) {
        return "-".repeat(car.getPosition(columnIndex));
    }
}
