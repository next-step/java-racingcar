package game.domain;

import game.io.output.RacingGameOutput;

import java.util.Random;

public class RacingGame {

    private static final Random random = new Random();
    private CarList carList;
    private RacingGameRule racingGameRule;
    private int round;

    public RacingGame(RacingGameRule racingGameRule, CarList cars, int round) {
        this.racingGameRule = racingGameRule;
        this.carList = cars;
        this.round = round;
    }

    public void progressGame() {
        RacingGameOutput.startGame();
        for (int i = 0; i < round(); i++) {
            progressRound(carList);
        }
    }

    private void progressRound(CarList carList) {
        for (Car car : carList.cars()) {
            forwardByRule(car, pickRandomNumber());
        }
        RacingGameOutput.printCarsStatus(carList);
        RacingGameOutput.finishRound();
    }

    public void forwardByRule(Car car, int number) {
        if (racingGameRule.isForward(number)) {
            car.forward(racingGameRule.forwardDistance());
        }
    }

    public CarList carList() {
        return carList;
    }

    public int round() {
        return round;
    }

    public int pickRandomNumber() {
        return random.nextInt(racingGameRule.bound());
    }

}
