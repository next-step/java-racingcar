package racingcar.domain;

import racingcar.util.RandomNumberUtil;

public class RacingGame {
    private final int rounds;
    private final Cars cars;
    private final RaceRecords raceRecords;

    public RacingGame(Cars cars, int rounds) {
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
        cars.getCars().forEach(c -> c.tryToMove(RandomNumberUtil.getRandomNumber()));
        raceRecords.getRaceRecords().add(new RaceRecord(round, raceRecords.saveRecords(cars)));
    }
}
