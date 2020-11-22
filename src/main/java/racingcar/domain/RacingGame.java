package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final int rounds;
    private final Cars cars;
    private final RaceRecords raceRecords;

    private RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.raceRecords = new RaceRecords();
    }
    public static RacingGame newRacingGame(Cars cars, int rounds) {
        return new RacingGame(cars, rounds);
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
        cars.tryToMove();
        raceRecords.saveSingleRoundRecord(round, cars);
    }

    public List<Car> getWinner() {
        return cars.getCarsByName(raceRecords.getWinner());
    }
}
