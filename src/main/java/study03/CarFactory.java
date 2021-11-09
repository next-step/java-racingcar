package study03;

import java.util.LinkedList;
import java.util.List;

/*
 *
 * CarFactory
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class CarFactory {

    private final List<Car> cars = new LinkedList<>();

    public CarFactory(int carCount) {
        for (int i = 1; i <= carCount; i++) {
            this.cars.add(new Car());
        }
    }

    public void moveCarsPerTryCount(int tryNumber) {
        System.out.println(tryNumber + "회차");
        cars.forEach(x -> x.moveOnSatisfiedCondition(ConditionGenerator.generate()));
    }
}

