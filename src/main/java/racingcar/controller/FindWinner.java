package racingcar.controller;

import racingcar.domain.Car;

import java.util.List;

public class FindWinner {
    public static String getWinner(List<Car> cars) {
        StringBuilder winnersBuilder = new StringBuilder();
        int maxScore = 0;
        for (Car car : cars) {
            int nowPosition = car.getPosition();
            if (maxScore < nowPosition) {
                maxScore = nowPosition;
                winnersBuilder.delete(0,winnersBuilder.length());
            }
            if (maxScore == nowPosition) {
                winnersBuilder.append(car.getName()).append(", ");
            }
        }
        String winners = winnersBuilder.substring(0, winnersBuilder.length() - 2);

        return winners;
    }
}
