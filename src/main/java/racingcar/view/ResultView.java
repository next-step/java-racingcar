package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void showResult(final List<Car> cars) {
        cars.forEach(this::printCurrentStatus);
        System.out.println();
    }

    private void printCurrentStatus(Car car) {
        StringBuilder currentStatus = new StringBuilder();
        currentStatus.append(car.getName())
                .append(" : ")
                .append(printPosition(car.getPosition()));
        System.out.println(currentStatus);
    }

    private String printPosition(Integer position) {
        StringBuilder currentPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            currentPosition.append('-');
        }

        return currentPosition.toString();
    }
}
