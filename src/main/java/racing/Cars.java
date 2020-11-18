package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] names) {
        createCars(names);
    }

    private void createCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public Cars go() {
        List<Car> raceRecord = new ArrayList<>();
        for (Car car : cars) {
            raceRecord.add(car.move(new MoveStrategyImpl()));
        }

        return new Cars(raceRecord);
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public List<Car> getCarList() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
