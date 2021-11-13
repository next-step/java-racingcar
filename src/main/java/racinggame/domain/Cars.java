package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private static final Integer START_INDEX = 0;

    private List<Car> cars;

    public static Cars from(Integer carCount) {
        return Cars.of(carCount, Location.START_LOCATION);
    }

    public static Cars of(Integer carCount, Integer location) {
        List<Car> entryCars = (IntStream.range(START_INDEX, carCount)
                .mapToObj((idx) -> new Car(location))
                .collect(Collectors.toList()));
        return new Cars(entryCars);
    }

    private Cars (List<Car> entryCars) {
       this.cars = entryCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void roundRacing(StateGenerator stateGenerator) {
        for (Car car : cars) {
            car.move(stateGenerator);
        }
    }
}
