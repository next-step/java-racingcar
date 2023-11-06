package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> carList;

    public static Cars from(String[] names, MovingValidator movingValidator) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(new CarName(name), movingValidator);
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

    public List<Distance> movingDistances() {
        List<Distance> distances = new ArrayList<>();
        for (Car car : this.carList) {
            distances.add(car.movingDistance());
        }

        return distances;
    }

    public boolean contain(Cars cars) {
        return equals(cars);
    }

    public List<Car> findAll() {
        return this.carList;
    }

    public Cars mostMoved() {
        Distance maxDistance = getMaxDistance();
        return mostMoved(maxDistance);
    }

    private Cars mostMoved(Distance maxDistance) {
        List<Car> mostMovedCars = new ArrayList<>();
        for (Car car : carList) {
            if (car.sameMoved(maxDistance)) {
                mostMovedCars.add(car);
            }
        }
        return new Cars(mostMovedCars);
    }

    private Distance getMaxDistance() {
        Distance maxDistance = new Distance();

        for (Car car : this.carList) {
            maxDistance = maxDistance.getLonger(car.movingDistance());
        }

        return maxDistance;
    }

    public List<CarName> names() {
        List<CarName> carNames = new ArrayList<>();
        for (Car car : carList) {
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
