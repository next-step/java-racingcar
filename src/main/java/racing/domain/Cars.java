package racing.domain;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_POSITION = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(name -> new Car(new CarName(CarName.checkCarName(name).getName()), new CarPosition(DEFAULT_POSITION)))
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void tryMove() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            car.tryMove(numberGenerator.getInt());
        }
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getCarPosition().getPosition(), maxPosition);
        }
        return maxPosition;
    }

    public Winners findWinners() {
        int maxPosition = getMaxPosition();
        return new Winners(cars.stream()
                .filter(car -> car.getCarPosition().getPosition() == maxPosition)
                .map(car -> car.getCarName().getName())
                .collect(Collectors.toList()));
    }
}
