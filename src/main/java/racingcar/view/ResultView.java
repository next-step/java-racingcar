package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void showResult(final Cars cars) {
        cars.getList().forEach(this::printCurrentStatus);
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

    public void showWinners(List<Car> winners) {
        StringBuilder winnerMessage = new StringBuilder();
        winnerMessage.append(
                winners.stream()
                        .map(Car::getName)
                        .collect(Collectors.joining(","))
        ).append("가 최종 우승했습니다.");

        System.out.println(winnerMessage);
    }
}
