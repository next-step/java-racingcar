package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private final int rounds;
    private final List<Car> cars;
    private final List<RaceRecord> raceRecords;


    public RacingGame(List<String> carNames, int rounds) {
        this.cars = makeCars(carNames);
        validateRounds(rounds);
        this.rounds = rounds;
        this.raceRecords = new ArrayList<>();
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

    private List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public void play() {
        for (int i = 1; i < rounds + 1; i++) {
            playSingleRound(i);
        }
    }

    private void playSingleRound(int round) {
        cars.forEach(Car::tryToMove);
        raceRecords.add(new RaceRecord(round, saveRecords()));
    }

    private Map<String, Integer> saveRecords() {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            map.put(car.getName(), car.getLocation());
        }
        return map;
    }

    public String getWinner() {
        RaceRecord raceRecord = getRaceRecords().get(getRaceRecords().size() - 1);
        Map<String, Integer> recordsWithCarName = raceRecord.getRecordsWithCarName();
        Map.Entry<String, Integer> winner = null;
        for (Map.Entry<String, Integer> entry : recordsWithCarName.entrySet()) {
            if (winner == null || entry.getValue().compareTo(winner.getValue()) > 0) {
                winner = entry;
            }
        }
        return winner.getKey();
    }
}
