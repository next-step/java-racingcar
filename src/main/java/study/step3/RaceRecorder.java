package study.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceRecorder {

    public static final String NON_NULL = "cars 값은 null 일수 없습니다";
    private final List<Car> cars;
    private final List<String> roundRecords;

    public RaceRecorder() {
        this.cars = new ArrayList<>();
        this.roundRecords = new ArrayList<>();
    }

    public String getAllRoundRecords() {
        return String.join("", roundRecords);
    }

    public void recordRound() {
        roundRecords.add(drawAllCarPosition());
    }

    public void prepareRecord(List<Car> cars) {
        validation(cars);
        watchAllCars(cars);
        recordBeforeRaceStart();
    }

    private void validation(List<Car> cars) {
        requireNonNull(cars);
    }

    private void requireNonNull(List<Car> cars) {
        if (Objects.isNull(cars)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void watchAllCars(List<Car> cars) {
        this.cars.clear();
        this.cars.addAll(cars);
    }

    private void recordBeforeRaceStart() {
        roundRecords.clear();
        recordRound();
    }

    private String drawAllCarPosition() {
        return cars.stream()
                .map(this::drawAccumulatedCarPosition)
                .collect(Collectors.joining("\n", "", "\n\n"));
    }

    private String drawAccumulatedCarPosition(Car car) {
        return repeat(car.getShape(), car.getPosition());
    }

    private String repeat(String carShape, int position) {
        return IntStream.range(0, position)
                .mapToObj(index -> carShape)
                .collect(Collectors.joining());
    }
}
