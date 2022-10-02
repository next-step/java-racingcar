package com.game.racing.domain.car;

import com.game.racing.domain.generator.NumberGenerator;
import com.game.racing.view.ResultView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final Map<String, Car> cars;

    public Cars(String[] carNames, NumberGenerator numberGenerator) {
        this.cars = new LinkedHashMap<>();
        addNewCarsWithNames(carNames, numberGenerator);
    }

    private void addNewCarsWithNames(String[] carNames, NumberGenerator numberGenerator) {
        for (String carName : carNames) {
            this.cars.put(carName, new Car(carName, numberGenerator));
        }
    }

    public Integer getTotalCarSize() {
        return cars.size();
    }

    public void moveCars() {
        for (String carName : cars.keySet()) {
            cars.get(carName).move();
        }
        ResultView.printNewLine();
    }

    public List<Car> getRacingCars() {
        return new ArrayList<>(cars.values());
    }
}
