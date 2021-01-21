package racingcar.controller;

import racingcar.domain.Car;

import java.util.List;

public class FindWinner {
    public static String getWinner(List<Car> cars) {
        StringBuilder winnersBuilder = new StringBuilder();
        cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        int maxScore = cars.get(0).getPosition();
        for (Car car : cars) {
            if (maxScore == car.getPosition()) {
                winnersBuilder.append(car.getName()).append(", ");
            }
        }
        String winners = winnersBuilder.substring(0, winnersBuilder.length() - 2);

        return winners;
    }
}
