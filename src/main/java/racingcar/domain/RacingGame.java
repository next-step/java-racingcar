package racingcar.domain;

import racingcar.util.RandomNumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private final int rounds;
    private final Cars cars;
    private final List<RaceRecord> raceRecords;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        validateRounds(rounds);
        this.rounds = rounds;
        this.raceRecords = new ArrayList<>();
    }

    public static RacingGame newRacingGame(Cars cars, int rounds) {
        return new RacingGame(cars, rounds);
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0)
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다 :) ");
    }

    public int getRounds() {
        return rounds;
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    public void play() {
        for (int i = 1; i < rounds + 1; i++) {
            playSingleRound(i);
        }
    }

    private void playSingleRound(int round) {
        cars.getCars().forEach(c -> c.tryToMove(RandomNumberUtil.getRandomNumber()));
        raceRecords.add(new RaceRecord(round, saveRecords()));
    }

    private Map<String, Integer> saveRecords() {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars.getCars()) {
            map.put(car.getName(), car.getLocation());
        }
        return map;
    }

    public String getWinner() {
        RaceRecord lastRaceRecord = getLastRaceRecord();
        Map<String, Integer> recordsWithCarName = lastRaceRecord.getRecordsWithCarName();
        Integer max = Collections.max(recordsWithCarName.values());
        return getWinnerNames(recordsWithCarName, max);
    }

    private RaceRecord getLastRaceRecord() {
        return getRaceRecords().get(getRaceRecords().size() - 1);
    }

    private String getWinnerNames(Map<String, Integer> map, Integer max) {
        StringBuilder winners = new StringBuilder();
        for (String name : map.keySet()) {
            if (map.get(name).equals(max)) {
                winners.append(name).append(", ");
            }
        }
        return winners.toString();
    }

}
