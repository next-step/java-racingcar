package racingcar.model;

import java.util.Collections;
import java.util.PriorityQueue;

public class Winner {
    private final String WIN_MESSAGE = "가 최종 우승했습니다.";
    private final String WINNER_JOIN_EXPRESSION = ", ";
    private final String NOT_EXIST_WINNER = "";
    private Cars cars;

    public Winner(final Cars cars) {
        this.cars = cars;
    }

    public String getWinner() {
        PriorityQueue<Car> rankedCars = rank();
        Car winner = rankedCars.poll();

        StringBuilder builder = new StringBuilder();
        builder.append(winner.getName());

        while (!rankedCars.isEmpty()) {
            builder.append(getSameRank(winner, rankedCars.poll()));
        }

        builder.append(WIN_MESSAGE);
        return builder.toString();
    }

    private PriorityQueue<Car> rank() {
        PriorityQueue<Car> ranks = new PriorityQueue<>(Collections.reverseOrder());
        for (Car car : cars.toList()) {
            ranks.offer(car);
        }
        return ranks;
    }

    private String getSameRank(final Car winner, final Car car) {
        if (winner.getDistance() == car.getDistance()) {
            return WINNER_JOIN_EXPRESSION + car.getName();
        }
        return NOT_EXIST_WINNER;
    }
}