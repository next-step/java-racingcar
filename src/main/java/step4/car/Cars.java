package step4.car;

import step4.RandomValueGenerator;
import step4.number.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = generateCars(carNames);
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryMove() {
        for (int i = 0; i < cars.size(); i++) {
            int randomValue = RandomValueGenerator.generate();
            Number number = new Number(randomValue);
            Car car = cars.get(i);
            car.tryMove(number);
        }
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        try {
            return cars.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(getOutOfIndexExceptionMessage(index));
        }
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public Cars getFarthestMovedCars() {
        List<Car> farthestCars = new ArrayList<>();
        Position maxPosition = Position.zero();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            clearIfPositionIsFarther(car, maxPosition, farthestCars);
            maxPosition = replaceMaxPositionIfFarther(car, maxPosition, farthestCars);
        }
        return new Cars(farthestCars);
    }

    private void clearIfPositionIsFarther(Car car, Position maxPosition, List<Car> farthestCars) {
        Position position = car.getPosition();
        if (position.compareTo(maxPosition) > 0)
            farthestCars.clear();
    }

    private Position replaceMaxPositionIfFarther(Car car, Position maxPosition, List<Car> farthestCars) {
        Position position = car.getPosition();
        if (position.compareTo(maxPosition) >= 0) {
            farthestCars.add(car);
            return position;
        }
        return maxPosition;
    }

    private String getOutOfIndexExceptionMessage(int index) {
        return String.format("Size : %d, index : %d", size(), index);
    }

    private List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            String carName = carNames[i];
            cars.add(new Car(carName));
        }
        return cars;
    }
}
