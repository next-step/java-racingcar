package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class PrintView {

    public void printResultTitle() {
        System.out.println();
        final String RESULT_MESSAGE = "실행결과";
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarStatus(List<Car> carList) {
        carList.forEach(car -> System.out.println(carToStatus(car)));
        System.out.println();
    }

    public String carToStatus(Car car) {
        final String NAME_POSITION_DELIMITER = " : ";
        final String POSITION_SIGN = "-";
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName())
                .append(NAME_POSITION_DELIMITER);

        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(POSITION_SIGN);
        }

        return builder.toString();
    }

    public void printWinners(List<Car> winners) {
        final String WINNER_MESSAGE = "가 최종 우승했습니다.";
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println(winnerNames + WINNER_MESSAGE);
    }
}
