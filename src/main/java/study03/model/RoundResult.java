package study03.model;

import java.util.LinkedList;
import java.util.List;

/*
 *
 * RoundResult
 *
 * @version 1.0.0
 *
 * 2021-11-11
 *
 * Copyright tnals1422
 */
public class RoundResult {

    private final List<Integer> resultPerCars = new LinkedList<>();

    public RoundResult(Cars cars) {
        cars.getCars()
                .forEach(car -> {
                    int position = car.getPosition();
                    this.resultPerCars.add(position);
                });
    }

    public List<Integer> getResult() {
        return resultPerCars;
    }
}
