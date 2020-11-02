package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;
    private final RacingStrategy racingStrategy;

    private Cars(List<Car> cars) {
        this.cars = cars;
        this.racingStrategy = new RandomRacingStrategy();
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(Integer carCount) {
        return of(Collections.nCopies(carCount, new Car(0)));
    }

    public void move() {
        cars.forEach(racingStrategy::move);
    }

    public List<List<Integer>> getRecords() {
        if (cars.size() == 0) {
            throw new IllegalStateException("no cars");
        }
        return IntStream.range(0, cars.get(0).getRecordCount())
                .mapToObj(this::getRecordsAtStep)
                .collect(Collectors.toList());
    }

    private List<Integer> getRecordsAtStep(int step) {
        return cars.stream()
                .map(car -> car.getRecordAtStep(step))
                .collect(Collectors.toList());
    }
}
