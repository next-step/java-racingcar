package com.nextstep.racinggame.domain;

import java.util.Arrays;

public class CarsFixtures {
    public static final Cars ALL_ONE_MOVED_CARS =
            new Cars(Arrays.asList(new Car(1), new Car(1), new Car(1)));
    public static final Cars ALL_NOT_MOVED_CARS =
            new Cars(Arrays.asList(new Car(0), new Car(0), new Car(0)));
}
