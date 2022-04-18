package me.devyonghee.racingcar.model.sample;

import me.devyonghee.racingcar.model.Movement;
import me.devyonghee.racingcar.model.CarName;
import me.devyonghee.racingcar.model.RacingCar;

public class RacingCarSample {

    public static final RacingCar ONLY_MOVE_CAR = RacingCar.from(CarName.from("abc"), () -> Movement.MOVE);
}
