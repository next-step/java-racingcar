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
}
