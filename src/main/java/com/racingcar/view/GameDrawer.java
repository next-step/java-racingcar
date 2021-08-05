package com.racingcar.view;

import com.racingcar.car.Car;
import com.racingcar.game.result.RoundCarRecord;

import java.util.List;
import java.util.stream.Collectors;

public class GameDrawer {
    private static final String CAR_NAME_SPLITER = " : ";

    public static void drawGameStart() {
        System.out.println("실행 결과");
    }

    public static void drawOneRound(List<RoundCarRecord> records) {
        records.stream()
                .forEach((record) -> {
                    String line = record.getName() + CAR_NAME_SPLITER + drawCarMoving(record.getDistance());
                    System.out.println(line);
                });
        System.out.println();
    }

    public static void drawWinners(List<Car> winners) {
        String result = extractWinnerNames(winners) + "가 최종 우승했습니다.";

        System.out.println(result);
    }

    private static String extractWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private static String drawCarMoving(int distance) {
        String line = "";

        for (int i = 0; i < distance; i++) {
            line += "-";
        }
        return line;
    }
}
