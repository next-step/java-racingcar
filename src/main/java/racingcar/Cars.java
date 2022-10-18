package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarsByNumber(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public static Cars createCarsByNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    public int findMaxPosition() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .orElseThrow()
            .getPosition();
    }

    public void moveCars(List<Boolean> movables) {
        for (int i = 0; i < cars.size(); i++) {
            if (movables.get(i)) {
                cars.get(i).forward();
            }
        }
    }

    public List<String> getCarNamesByPosition(int position) {
        List<String> names = new ArrayList<>();
        for (Car car: cars) {
            comparePositionAndAddNames(names, car, position);
        }

        return names;
    }

    private void comparePositionAndAddNames(List<String> names, Car car, int position) {
        if (car.isPosition(position)) {
            names.add(car.getName().getText());
        }
    }
}
