package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {

    private List<Car> cars;
    private int numberOfOperations;

    public RacingCarController(int numberOfParticipants, int numberOfOperations) {
        this.cars = IntStream.range(0, numberOfParticipants)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        this.numberOfOperations = numberOfOperations;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getOperationCount() {
        return numberOfOperations;
    }
}
