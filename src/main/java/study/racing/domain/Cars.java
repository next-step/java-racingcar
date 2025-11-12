package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = initCars(names);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> initCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        addCars(cars, names);
        return cars;
    }

    private void addCars(List<Car> cars, List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> topRankCars() {
        int topRankPoint = topRankPoint();
        return findTopRankCars(topRankPoint);
    }

    private int topRankPoint() {
        int maxPoint = 0;
        for (int i = 0; i < cars.size(); i++) {
            maxPoint = Math.max(maxPoint, cars.get(i).getPosition());
        }
        return maxPoint;
    }

    private List<Car> findTopRankCars(int topRankPoint) {
        List<Car> findTopCars = new ArrayList<>();
        for (Car car : cars) {
            if (topRankPoint == car.getPosition()) {
                findTopCars.add(car);
            }
        }
        return findTopCars;
    }

}
