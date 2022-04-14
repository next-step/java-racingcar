package racingcar.play;


import racingcar.racing.RacingCar;

public interface RacingGamePolicy {
    RacingCar racing(RacingCar racingCar, int tryNumber, int value);
}
