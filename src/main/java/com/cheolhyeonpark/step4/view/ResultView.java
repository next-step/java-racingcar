package com.cheolhyeonpark.step4.view;

import com.cheolhyeonpark.step4.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String GAME_RESULT = "실행결과";
    public static final String POSITION_BAR = "-";
    public static final String DELIMITER = ", ";

    public void printResultTitle() {
        System.out.println(GAME_RESULT);
    }

    public void printStageResult(List<Car> cars) {
        cars.forEach(this::printPosition);
        System.out.println();
    }

    public void printPosition(Car car) {
        System.out.println(car.getResult());
    }

    public void printWinners(List<Car> winners) {
        System.out.println(winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER))
                + "가 최종 우승했습니다.");
    }
}
