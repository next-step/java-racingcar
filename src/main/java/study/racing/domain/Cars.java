package study.racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(CarNames names) {
        this(initCars(names.value()));
    }

    public Cars(String... names) {
        this(initCars(Arrays.stream(names).map(CarName::new).toList()));
    }

    public Cars(Car... cars) {
        this(List.of(cars));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public static List<Car> initCars(List<CarName> names) {
        List<Car> cars = new ArrayList<>();
        addCars(cars, names);
        return cars;
    }

    private static void addCars(List<Car> cars, List<CarName> names) {
        for (CarName name : names) {
            cars.add(new Car(name.value()));
        }
    }

    public List<Car> topRankCars() {
        int topRankPoint = topRankPoint();
        return findTopRankCars(topRankPoint);
    }

    private int topRankPoint() {
        int maxPoint = 0;
        for (Car car : cars) {
            maxPoint = car.max(maxPoint);
        }
        return maxPoint;
    }

    private List<Car> findTopRankCars(int topRankPoint) {
        List<Car> findTopCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isEqualsMaxPosition(topRankPoint)) {
                findTopCars.add(car);
            }
        }
        return findTopCars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
