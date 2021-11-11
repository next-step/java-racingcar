package com.kkambi.racing.view;

import com.kkambi.racing.domain.Car;

import java.util.List;

public class ResultView {

    public void printLocation(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getLocation());
        }
        System.out.println();
    }
}
