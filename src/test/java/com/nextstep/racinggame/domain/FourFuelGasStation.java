package com.nextstep.racinggame.domain;

public class FourFuelGasStation implements GasStation {
    @Override
    public Fuel refuel() {
        return new Fuel(4);
    }
}
