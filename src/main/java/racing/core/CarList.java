package racing.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarList {
    public static final String CAR_NAME_REGEX = ",";

    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public Stream<Car> getCarStream() {
        return cars.stream();
    }

    public void sortDesc() {
        cars.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
    }

    public Car getFirstCar() {
        return cars.get(0);
    }

    public CarList getCarsWithSameDistance(int distance) {
        List<Car> result = this.getCarStream()
                .filter(car -> car.getDistance() == distance)
                .collect(Collectors.toList());
        return new CarList(result);
    }

    public static CarList makeCars(Car... cars) {
        return new CarList(Arrays.asList(cars));
    }

    public static CarList makeCars(String carNamesFromClient) {
        String[] carNames = carNamesFromClient.split(CAR_NAME_REGEX);
        return makeCars(carNames);
    }

    public static CarList makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new CarList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarList carList = (CarList) o;
        if(this.cars.size() != carList.cars.size()) return false;
        for(int i = 0; i < cars.size(); i++){
            if(!cars.get(i).equals(carList.cars.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
