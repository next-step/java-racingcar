package com.iksoo.step4.model;

import com.iksoo.step4.controller.CarMainController;

import java.util.List;
import static com.iksoo.step4.view.CarOutputData.printBlankLine;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        startRacing(this.cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void startRacing(List<Car> cars) {
        for (int i = 0; i < cars.get(0).getTotalInning(); i++) {
            doOneInning(cars);
        }
    }

    public void doOneInning(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).doRacing(CarMainController.getRandom());
        }
    }
}
