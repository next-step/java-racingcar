package game.domain.game;

import game.domain.car.Car;
import game.domain.car.RacingGameCarList;
import game.domain.rule.RacingGameRule;

import java.util.Random;

public class RacingGame {

    private RacingGameCarList racingGameCarList;
    private RacingGameRule racingGameRule;
    private Round round;
    private static final Random RANDOM = new Random();


    public RacingGame(RacingGameRule racingGameRule, RacingGameCarList cars, int round) {
        this.racingGameRule = racingGameRule;
        this.racingGameCarList = cars;
        this.round = new Round(round);
    }

    public void progressRound() {
        for (Car car : racingGameCarList.cars()) {
            car.forward(racingGameRule, pickRandomNumber());
        }
    }

    public RacingGameCarList carList() {
        return new RacingGameCarList(racingGameCarList);
    }

    public Round round() {
        return new Round(round);
    }

    public int pickRandomNumber() {
        return RANDOM.nextInt(racingGameRule.bound().getBound());
    }

}
