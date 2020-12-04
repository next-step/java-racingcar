package com.nextstep.racinggame.domain;

import java.util.Arrays;

public class CarsFixtures {
    public static final Cars ALL_ONE_MOVED_CARS =
            new Cars(Arrays.asList(
                    new Car(1, new Name("test1")),
                    new Car(1, new Name("test2")),
                    new Car(1, new Name("test3")))
            );
    public static final Cars ALL_NOT_MOVED_CARS =
            new Cars(Arrays.asList(
                    new Car(0, new Name("test1")),
                    new Car(0, new Name("test2")),
                    new Car(0, new Name("test3")))
            );
}
