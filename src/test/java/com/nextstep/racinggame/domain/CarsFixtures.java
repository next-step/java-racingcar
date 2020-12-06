package com.nextstep.racinggame.domain;

import java.util.Arrays;

public class CarsFixtures {
    private static final Name TEST1 = new Name("test1");
    private static final Name TEST2 = new Name("test2");
    private static final Name TEST3 = new Name("test3");

    public static final Cars ALL_ONE_MOVED_TEST123_CARS =
            new Cars(Arrays.asList(new Car(1, TEST1), new Car(1, TEST2), new Car(1, TEST3)));
    public static final Cars ALL_NOT_MOVED_TEST123_CARS =
            new Cars(Arrays.asList(new Car(0, TEST1), new Car(0, TEST2), new Car(0, TEST3)));
    public static final Cars TEST1_TEST2_WINNING_CARS =
            new Cars(Arrays.asList(new Car(1, TEST1), new Car(1, TEST2)));
}
