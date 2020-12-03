package com.nextstep.racinggame.domain;

public class ThreeFuelGasStation implements GasStation {
    @Override
    public Fuel refuel() {
        return new Fuel(3);
    }
}
