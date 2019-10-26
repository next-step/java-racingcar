package racingcar.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private final List<Car> cars = new ArrayList<>();
    private final Recording recording = new Recording();
    private int countOfMovesAttemps = 0;

    public void initialize(int countOfCars, int countOfMovesAttemps) {
        registerCarsToParticipateInRace(countOfCars);
        setCountOfMovesAttemps(countOfMovesAttemps);
    }

    private void registerCarsToParticipateInRace(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.of(CarName.get(i)));
        }
    }

    private void setCountOfMovesAttemps(int countOfMovesAttemps) {
        this.countOfMovesAttemps = countOfMovesAttemps;
    }

    public void start() {
        for (int i = 0; i < countOfMovesAttemps; i++) {
            progress();
        }
    }

    private void progress() {
        cars.forEach(Car::race);
        recording.saveRacingHistory(cars);
    }

    public Recording getRecordingData() {
        return this.recording;
    }

    public static class Recording {
        private final List<Map<String, Integer>> racingHistory = new ArrayList<>();

        void saveRacingHistory(List<Car> cars) {
            Map<String, Integer> history = new HashMap<>();

            cars.forEach(car -> history.put(car.getName(), car.getTotalDistance()));

            racingHistory.add(history);
        }

        public List<Map<String, Integer>> getRacingHistory() {
            return this.racingHistory;
        }
    }
}
