package com.nextstep.racinggame.domain;

public class StaticGasStation implements GasStation {
    @Override
    public Fuel refuel() {
        return new Fuel(5);
    }
}
