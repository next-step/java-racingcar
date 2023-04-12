package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    public Integer totalCarCount;
    public Integer totalMoveCount;

    public Race(Integer totalCarCount, Integer totalMoveCount) {
        this.totalCarCount = totalCarCount;
        this.totalMoveCount = totalMoveCount;
    }

    public void start(Output output) {
        List<Car> cars = createCars(output);
        output.printExecutionHeader();
        for (int i = 0; i < this.totalMoveCount; i++) {
            moveCarsAndPrint(output, cars);
        }
    }

    private List<Car> createCars(Output output) {
        return IntStream.range(0, totalCarCount)
                .mapToObj(i -> new Car(output))
                .collect(Collectors.toList());
    }

    private void moveCarsAndPrint(Output output, List<Car> cars) {
        cars.forEach(Car::moveAndPrint);
        output.printBlankLine();
    }
}
