package step4.domain;

import step4.RecordDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;
    private final RacingStrategy racingStrategy;

    private Cars(List<Car> cars, RacingStrategy racingStrategy) {
        this.cars = cars;
        this.racingStrategy = racingStrategy;
    }

    public static Cars of(List<Car> cars, RacingStrategy racingStrategy) {
        return new Cars(cars, racingStrategy);
    }

    public static Cars ofNames(List<String> names, RacingStrategy racingStrategy) {
        return of(names.stream().map(name -> new Car(name, 0)).collect(Collectors.toList()), racingStrategy);
    }

    public void move() {
        cars.forEach(racingStrategy::move);
    }

    public List<List<RecordDto>> getRecords() {
        if (cars.size() == 0) {
            throw new IllegalStateException("no cars");
        }
        return IntStream.range(0, cars.get(0).getRecordCount())
                .mapToObj(this::getRecordsAtStep)
                .collect(Collectors.toList());
    }

    private List<RecordDto> getRecordsAtStep(int step) {
        return cars.stream()
                .map(car -> car.getRecordAtStep(step))
                .collect(Collectors.toList());
    }

    public List<RecordDto> getWinnerRecord() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("no maximum"));
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .map(Car::getFinalRecord)
                .collect(Collectors.toList());
    }
}
