package racingcar.domain;

import racingcar.util.RandomNumberUtil;

public class RacingGame {
    private final int rounds;
    private final Cars cars;
    private final RaceRecords raceRecords;

    public RacingGame(Cars cars, RaceRecords raceRecords, int rounds) {
        this.cars = cars;
        this.raceRecords = raceRecords;
        validateRounds(rounds);
        this.rounds = rounds;
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0)
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다 :) ");
    }

    public static RacingGame newRacingGame(Cars cars, RaceRecords raceRecords, int rounds) {
        return new RacingGame(cars, raceRecords, rounds);
    }

    public int getRounds() {
        return rounds;
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
