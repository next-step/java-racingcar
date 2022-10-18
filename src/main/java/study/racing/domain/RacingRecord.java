package study.racing.domain;

import java.util.*;

public class RacingRecord {
    private Map<Car, Map<Integer, Integer>> records = new HashMap<>();
    private int totalRound;

    public RacingRecord(List<Car> cars) {
        cars.forEach(car -> records.put(car, new HashMap<>()));
    }

    public void record(Car car, int round, int distance) {
        records.get(car).put(round, distance);
        totalRound = Math.max(totalRound, round);
    }

    public Map<Car, Map<Integer, Integer>> getRecords() {
        return this.records;
    }

    public List<Car> findWinners() {
        int maxDistance = getMaxDistance();

        List<Car> winners = new ArrayList<>();
        Iterator<Car> carIterator = records.keySet().iterator();

        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            extractWinner(winners ,car, maxDistance);
        }

        return winners;
    }

    private void extractWinner(List<Car> winners, Car car, int maxDistance) {
        Map<Integer, Integer> record = records.get(car);
        if (record.get(totalRound) == maxDistance) {
            winners.add(car);
        }
    }

    private int getMaxDistance() {
        Iterator<Car> carSet = records.keySet().iterator();
        int maxDistance = 0;
        while (carSet.hasNext()) {
            Map<Integer, Integer> record = records.get(carSet.next());
            maxDistance = Math.max(maxDistance, record.get(totalRound));
        }
        return maxDistance;
    }

    public int getTotalRound() {
        return this.totalRound;
    }
}
