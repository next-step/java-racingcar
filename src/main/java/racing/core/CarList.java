package racing.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CarList {
    public static final String CAR_NAME_REGEX = ",";

    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public Stream<Car> getCarStream(){
        return cars.stream();
    }

    public void sortDesc(){
        cars.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
    }

    public Car getFirstCar(){
        return cars.get(0);
    }

    public static CarList makeCars(String carNamesFromClient) {
        String[] carNames = carNamesFromClient.split(CAR_NAME_REGEX);
        return makeCars(carNames);
    }

    public static CarList makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return new CarList(cars);
    }
}
