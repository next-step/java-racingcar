package com.next.step.step3.domain;

import java.util.List;

public class CarsFixture {

    public static List<Car> 동일한_위치_CARS() {
        return List.of(
                new Car(3, "a"),
                new Car(3, "b"),
                new Car(3, "c")
        );
    }

    public static List<Car> 동일한_2개_위치_CARS() {
        return List.of(
                new Car(1, "a"),
                new Car(3, "b"),
                new Car(3, "c")
        );
    }

    public static List<Car> 유일한_위치_CARS() {
        return List.of(
                new Car(1, "a"),
                new Car(2, "b"),
                new Car(3, "c")
        );
    }
}
