package me.devyonghee.racingcar.model.sample;

import me.devyonghee.racingcar.model.*;

public class CarPreparerSample {

    public static final CarPreparer ZERO_DISTANCE_PREPARER = CarPreparer.of(CarFactory.of(NameWriter.from("abc"), () -> Movement.MOVE), Distance.ZERO);
}
