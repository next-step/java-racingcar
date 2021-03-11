package step33;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarRacing {

    private List<Car> cars;

    public CarRacing(int amountOfCar) {
        this.cars = Stream.generate(Car::new)
                .limit(amountOfCar)
                .collect(Collectors.toList());
    }

    public List<CarResponse> start(RandomGenerator randomGenerator, int index) {
        return IntStream.range(0, index)
                .mapToObj(count -> getMovesOfCar(randomGenerator))
                .map(this::getCarResponse)
                .collect(Collectors.toList());
    }

    private CarResponse getCarResponse(List<Integer> carMoves) {
        return CarResponse.of(carMoves);
    }

    private List<Integer> getMovesOfCar(RandomGenerator randomGenerator) {
        return cars.stream()
                .map(car -> car.moveCars(randomGenerator.getRandomNumber()))
                .collect(Collectors.toList());
    }
}
