package com.step3.view;

import com.step3.model.car.Car;
import com.step3.model.car.Cars;

import java.util.stream.Collectors;

public class ResultView {
    public static void showResults(Cars cars, int attempt) {
        if (attempt == 0) {
            System.out.println("실행 결과");
        }

        for (Car car : cars.getCars()) {
            System.out.println(String.format("%s%s%s", car.getId().getValue(), ":", getResult(car)));
        }

        System.out.println();
    }

    private static String getResult(Car car) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < car.getPosition().getCarPosition(); idx++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public static void printWinnerResult(Cars cars) {
        System.out.println(String.format("%s가 최종 우승했습니다.", getWinnerResult(cars)));
    }

    private static String getWinnerResult(Cars cars) {
        return cars.getWinnerCars().stream()
                .map(c -> c.getId().getValue())
                .collect(Collectors.joining(","));
    }
}
