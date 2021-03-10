package step33;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {

    private List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public List<CarResponse> start(RandomGenerator randomGenerator, int index) {
        return IntStream.range(0, index)
                .mapToObj(count -> getMovesOfCar(randomGenerator))
                .collect(Collectors.toList());
    }

    private CarResponse getMovesOfCar(RandomGenerator randomGenerator) {
        List<String> carMoves = cars.stream()
                .map(car -> getMovesOfCar(randomGenerator, car))
                .collect(Collectors.toList());

        return CarResponse.of(carMoves);
    }

    private String getMovesOfCar(RandomGenerator randomGenerator, Car car) {
        int randomNumber = randomGenerator.getRandomNumber();
        boolean isOver = randomGenerator.isOver(randomNumber);

        return car.moveCars(isOver);
    }

}
