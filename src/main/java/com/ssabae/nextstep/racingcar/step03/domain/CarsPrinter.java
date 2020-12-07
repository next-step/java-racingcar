package com.ssabae.nextstep.racingcar.step03.domain;

import java.util.List;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-07
 */
public class CarsPrinter {

    public void print(Cars cars) {
        List<Car> carList = cars.getCarList();
        carList.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.println(car.getPrintString());
    }
}
