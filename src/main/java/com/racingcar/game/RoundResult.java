package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundResult {
    Map<Integer, Integer> result = new HashMap<>();

    public void add(Car car) {
        result.put(car.getId(), car.getDistance());
    }

    public int get(int id) {
        return result.get(id);
    }

    public List<Integer> getCarIdList() {
        return new ArrayList<>(result.keySet());
    }
}
