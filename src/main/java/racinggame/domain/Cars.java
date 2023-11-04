package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import racinggame.domain.strategy.RandomNumberMovingStrategy;

public class Cars {

    private final List<Car> carList;

    public static Cars from(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(new CarName(name),
                new MovingValidator(new RandomNumberMovingStrategy(new Random())));
            cars.add(car);
        }
        return new Cars(cars);
    }

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public int size() {
        return this.carList.size();
    }

    public void move() {
        for (Car car : this.carList) {
            car.move();
        }
    }

    public List<MovingDistance> movingDistances() {
        List<MovingDistance> movingDistances = new ArrayList<>();
        for (Car car : this.carList) {
            movingDistances.add(car.movingDistance());
        }

        return movingDistances;
    }

    public Car get(int index) {
        return carList.get(index);
    }

    public List<Car> getAll() {
        return this.carList;
    }

    public Cars mostMoved() {
        MovingDistance maxDistance = getMaxDistance();
        return mostMoved(maxDistance);
    }

    private Cars mostMoved(MovingDistance maxDistance) {
        List<Car> mostMovedCars = new ArrayList<>();
        for(Car car : carList) {
            if(car.sameMoved(maxDistance)) mostMovedCars.add(car);
        }
        return new Cars(mostMovedCars);
    }

    private MovingDistance getMaxDistance() {
        MovingDistance maxDistance = new MovingDistance();

        for (Car car : this.carList) {
            maxDistance = max(maxDistance, car.movingDistance());
        }

        return maxDistance;
    }

    private MovingDistance max(MovingDistance existingDistance, MovingDistance comparisonDistance) {
        if(existingDistance.isBigger(comparisonDistance)) {
            return existingDistance;
        }
        return comparisonDistance;
    }

    public List<CarName> names() {
        List<CarName> carNames = new ArrayList<>();
        for(Car car : carList) {
            carNames.add(car.name());
        }
        return carNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars = (Cars) o;
        return Objects.equals(carList, cars.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }

}
