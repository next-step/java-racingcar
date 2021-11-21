package com.step3.view;

import com.step3.model.car.Car;
import com.step3.model.car.Cars;

import java.util.stream.Collectors;

public class ResultView {
    private static final String MOVE_MARK = "-";
    private static final String CAR_NAMES_SPLIT_MARK = ",";

    public static void showResults(Cars cars, int attempt) {
        if (attempt == 0) {
            System.out.println("실행 결과");
        }

        for (Car car : cars.getList()) {
            System.out.println(String.format("%s%s%s", car.getName().getValue(), ":", getResult(car)));
        }

        System.out.println();
    }

    public static void printWinnerResult(Cars cars) {
        System.out.println(String.format("%s가 최종 우승했습니다.", getWinnerResult(cars)));
    }

    private static String getResult(Car car) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < car.getPosition().getValue(); idx++) {
            sb.append(MOVE_MARK);
        }

        return sb.toString();
    }

    private static String getWinnerResult(Cars cars) {
        return cars.getWinnerCars().getList().stream()
                .map(c -> c.getName().getValue())
                .collect(Collectors.joining(CAR_NAMES_SPLIT_MARK));
    }
}
