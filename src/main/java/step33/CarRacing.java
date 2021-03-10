package step33;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {

    private Car car;
    private RandomGenerator randomGenerator;

    public CarRacing(Car car, RandomGenerator randomGenerator) {
        this.car = car;
        this.randomGenerator = randomGenerator;
    }

    public void createCars(int amountOfCars) {
        car.createCar(amountOfCars);
    }

    public List<CarResponse> start(int countOfCarRacing) {
        return IntStream.range(0, countOfCarRacing)
                .mapToObj(i -> getResponse())
                .collect(Collectors.toList());
    }

    private CarResponse getResponse() {
        List<Integer> carsSizes = car.carsSizes();
        moveCars(carsSizes.size());

        return CarResponse.of(carsSizes);
    }

    private void moveCars(int index) {
        for (int i = 0; i < index; i++) {
            int randomNumber = randomGenerator.getRandomNumber();
            boolean isOver = randomGenerator.isOver(randomNumber);
            car.moveCars(isOver, i);
        }
    }
}
