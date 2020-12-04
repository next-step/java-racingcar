package com.nextstep.racinggame.domain;

import java.util.Arrays;

import static com.nextstep.racinggame.domain.CarFixtures.*;

public class CarsFixtures {
    public static final Cars ALL_ONE_MOVED_TEST123_CARS =
            new Cars(Arrays.asList(ONE_TEST1_CAR, ONE_TEST2_CAR, ONE_TEST3_CAR));
    public static final Cars ALL_NOT_MOVED_TEST123_CARS =
            new Cars(Arrays.asList(ZERO_TEST1_CAR, ZERO_TEST2_CAR, ZERO_TEST3_CAR));
}
