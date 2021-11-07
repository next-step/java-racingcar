package com.step3.view;

import com.step3.model.Car;

import java.util.List;

public class ResultView {
    public static void showResults(List<Car> list, int attempt) {
        if (attempt == 0) {
            System.out.println("실행 결과");
        }

        for (Car car : list) {
            System.out.println(car.getResult());
        }

        System.out.println();
    }
}
