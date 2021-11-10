package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private static final Integer START_INDEX = 0;

    private final List<Car> cars;

    public Cars(Integer carCount) {
        cars = IntStream.range(START_INDEX, carCount)
                .mapToObj((idx) -> new Car())
                .collect(Collectors.toList());;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void roundRacing(StateGenerator stateGenerator) {
        for (Car car : cars) {
            car.move(stateGenerator.getState());
        }
    }
}
