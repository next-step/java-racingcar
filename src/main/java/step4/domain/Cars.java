package step4.domain;

import step4.RecordDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars ofNames(List<String> names) {
        return of(names.stream().map(Car::new).collect(Collectors.toList()));
    }

    public void move(RacingStrategy racingStrategy) {
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
                .mapToInt(car -> car.getFinalRecord().getRecord())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("no maximum"));
        return cars.stream()
                .filter(car -> car.getFinalRecord().getRecord().equals(maxPosition))
                .map(Car::getFinalRecord)
                .collect(Collectors.toList());
    }
}
