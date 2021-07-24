package step3.domain;

import java.util.List;

public class CarRacingGame {

    private final RacingCars cars;
    private List<Round> playedRounds;

    private CarRacingGame(int carCount) {
        cars = new RacingCars(carCount);
    }

    public static CarRacingGame createRacingGameWithCarCount(int carCount) {
        return new CarRacingGame(carCount);
    }


    public void gameStart(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            playOneRound(cars);
        }
    }

    private void playOneRound(RacingCars cars) {
        Round round = new Round();
        round.start(cars);

        playedRounds.add(round);
    }


}
