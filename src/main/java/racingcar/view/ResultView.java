package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {
    private StringBuilder result = new StringBuilder();

    public void saveResults(List<Car> cars) {
        for (Car car : cars) {
            saveCurrentPosition(car);
        }
        saveEmptyLine();
    }

    public void printResult() {
        System.out.println(result);
    }

    private void saveCurrentPosition(Car car) {
        int position = car.getPosition();
        String positionStr = "-".repeat(position);
        result.append(positionStr);
    }

    private void saveEmptyLine() {
        result.append(System.lineSeparator());
    }
}
