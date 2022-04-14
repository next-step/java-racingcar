package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

public final class CarFactory {

    private final NameWriter nameWriter;
    private final MovementPolicy policy;

    private CarFactory(NameWriter nameWriter, MovementPolicy policy) {
        Assert.notNull(nameWriter, "'nameWriter' must not be null");
        Assert.notNull(policy, "'policy' must not be null");
        this.nameWriter = nameWriter;
        this.policy = policy;
    }

    public static CarFactory of(NameWriter nameWriter, MovementPolicy policy) {
        return new CarFactory(nameWriter, policy);
    }

    RacingCars cars() {
        return RacingCars.from(nameWriter.names()
                .map(name -> RacingCar.from(name, policy)));
    }

    @Override
    public String toString() {
        return "CarFactory{" +
                "nameWriter=" + nameWriter +
                ", policy=" + policy +
                '}';
    }
}
