package step3.racingcar.model;

import java.util.Scanner;
import step3.racingcar.exception.RacingCarGameException;

public class RacingCarGameSet {

    private RacingCar[] cars;
    private RacingCarGameRound[] gameRounds;

    public RacingCarGameSet(RacingCar[] cars, RacingCarGameRound[] gameRounds) {
        this.cars = cars;
        this.gameRounds = gameRounds;
    }

    public RacingCar[] cars() {
        return this.cars;
    }

    public RacingCarGameRound[] gameRounds() {
        return this.gameRounds;
    }

}
