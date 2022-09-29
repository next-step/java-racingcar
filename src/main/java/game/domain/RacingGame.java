package game.domain;

import game.domain.car.Car;
import game.domain.car.RacingGameCar;
import game.io.output.RacingGameOutput;

import java.util.ArrayList;
import java.util.List;

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
        RacingGameOutput.endGame(winners(racingGameCarList));
    }

    public RacingGameCarList winners(RacingGameCarList racingGameCarList) {
        List<RacingGameCar> winners = new ArrayList<>();
        int winnerLocation = winnerLocation(racingGameCarList);
        for (RacingGameCar racingGameCar : racingGameCarList.cars()) {
            isWinner(winners, winnerLocation, racingGameCar);
        }
        return new RacingGameCarList(winners);
    }

    private static void isWinner(List<RacingGameCar> winners, int winnerLocation, RacingGameCar racingGameCar) {
        if(racingGameCar.location() == winnerLocation){
            winners.add(racingGameCar);
        }
    }

    private static int winnerLocation(RacingGameCarList racingGameCarList) {
        int max = Integer.MIN_VALUE;
        for (RacingGameCar car : racingGameCarList.cars()) {
            max = Math.max(car.location(),max);
        }
        return max;
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
