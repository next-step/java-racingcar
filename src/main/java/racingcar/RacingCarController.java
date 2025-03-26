package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {

    private List<Car> cars;

    public RacingCarController(int numberOfParticipants) {
        this.cars = IntStream.range(0, numberOfParticipants)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
