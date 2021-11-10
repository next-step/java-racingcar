package com.kakao.racingcar.domain.car;


import com.kakao.racingcar.history.CarHistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CarCollection {

    private final List<Car> cars;

    public CarCollection(List<String> userNames) {
        this.cars = userNames.stream()
                .map(userName -> new Car(userName, new RandomStrategy()))
                .collect(Collectors.toList());
    }

    public List<CarHistory> tryMoveCars(List<Integer> conditionNumbers) {
        List<CarHistory> carHistories = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            CarHistory carHistory = cars.get(i).tryMove(conditionNumbers.get(i));
            carHistories.add(carHistory);
        }
        return Collections.unmodifiableList(carHistories);
    }

    public int size() {
        return cars.size();
    }

}
