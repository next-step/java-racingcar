package game.domain;

import game.domain.car.Car;
import game.io.output.RacingGameOutput;

import java.util.Random;

public class RacingGame {

    private RacingGameCarList racingGameCarList;
    private RacingGameRule racingGameRule;
    private int round;
    private static final Random RANDOM = new Random();


    public RacingGame(RacingGameRule racingGameRule, RacingGameCarList cars, int round) {
        this.racingGameRule = racingGameRule;
        this.racingGameCarList = cars;
        this.round = round;
    }

    public void progressGame() {
        RacingGameOutput.startGame();
        for (int i = 0; i < round(); i++) {
            progressRound(racingGameCarList);
        }
        RacingGameOutput.endGame(racingGameCarList.winners());
    }

    private void progressRound(RacingGameCarList racingGameCarList) {
        for (Car car : racingGameCarList.cars()) {
            car.forward(racingGameRule, pickRandomNumber());
        }
        RacingGameOutput.printCarsStatus(racingGameCarList);
        RacingGameOutput.finishRound();
    }

    public RacingGameCarList carList() {
        return racingGameCarList;
    }

    public int round() {
        return round;
    }

    public int pickRandomNumber() {
        return RANDOM.nextInt(racingGameRule.bound());
    }

}
