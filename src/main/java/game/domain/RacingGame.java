package game.domain;

import game.domain.car.Car;
import game.io.output.RacingGameOutput;

public class RacingGame {

    private RacingGameCarList racingGameCarList;
    private RacingGameRule racingGameRule;
    private int round;

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
            car.forward(racingGameRule);
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

}
