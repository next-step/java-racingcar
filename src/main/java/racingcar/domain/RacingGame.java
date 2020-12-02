package racingcar.domain;

import racingcar.util.RandomNumberUtil;

import java.util.List;

public class RacingGame {
    private final int rounds;
    private final Cars cars;
    private final RaceRecords raceRecords;
    private final MoveRule moveRule;

    private RacingGame(Cars cars, int rounds, MoveRule moveRule) {
        this.cars = cars;
        this.rounds = rounds;
        this.raceRecords = new RaceRecords();
        this.moveRule = moveRule;
    }
    public static RacingGame newRacingGame(Cars cars, int rounds, MoveRule moveRule) {
        return new RacingGame(cars, rounds, moveRule);
    }

    public RaceRecords getRaceRecords() {
        return raceRecords;
    }

    public void play() {
        for (int i = 1; i < rounds + 1; i++) {
            playSingleRound(i);
        }
    }

    private void playSingleRound(int round) {
        cars.tryToMove(moveRule);
        raceRecords.saveSingleRoundRecord(round, cars);
    }

    public List<Car> getWinner() {
        return cars.getCarsByName(raceRecords.getWinner());
    }
}
