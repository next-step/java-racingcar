package com.nextstep.javaRacing.racing.view;

import com.nextstep.javaRacing.racing.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String ANNOUNCE_MSG_POSTFIX = "가 최종 우승했습니다.";

    public static void drawCircuit(int turn, List<Car> cars) {
        System.out.println();
        System.out.println("turn : "+ (turn+1));
        cars.forEach(ResultView::drawCar);
    }

    private static void drawCar(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void drawWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(String.join(", ", winnerNames) + ANNOUNCE_MSG_POSTFIX);
    }
}
