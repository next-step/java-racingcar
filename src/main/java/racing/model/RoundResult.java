package racing.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 *
 * RoundResult
 *
 * @version 1.0.0
 *
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class RoundResult {

    private final List<Car> resultPerCars = new LinkedList<>();

    public RoundResult(Cars cars) {
        cars.getCars()
                .forEach(car -> {
                    this.resultPerCars.add(new Car(car.getName(), car.getPosition()));
                });
    }
    public List<Car> getRecords() {
        return Collections.unmodifiableList(resultPerCars);
    }
}
