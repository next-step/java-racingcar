package com.view;

import com.Car;

import java.util.List;

public class ResultView {
    public void showResult(List<Car> list) {
        for (Car car : list) {
            System.out.println(car.getResult());
        }
        System.out.println();
    }
}
