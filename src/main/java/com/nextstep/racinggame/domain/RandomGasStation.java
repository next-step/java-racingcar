package com.nextstep.racinggame.domain;

import java.util.Random;

public class RandomGasStation implements GasStation {
    private static final int RANDOM_RANGE = 10;
    private static final Random RANDOM = new Random();

    @Override
    public Fuel refuel() {
        return new Fuel(RANDOM.nextInt(RANDOM_RANGE));
    }
}
