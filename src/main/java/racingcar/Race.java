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

    public void start() {
        List<Car> cars = createCars();
        printExecutionHeader();
        for (int i = 0; i < this.totalMoveCount; i++) {
            moveCarsAndPrint(cars);
        }
    }

    private List<Car> createCars() {
        return IntStream.range(0, totalCarCount)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    private void moveCarsAndPrint(List<Car> cars) {
        cars.forEach(Car::moveAndPrint);
        System.out.println();
    }

    private void printExecutionHeader() {
        System.out.println("\n실행 결과");
    }
}
