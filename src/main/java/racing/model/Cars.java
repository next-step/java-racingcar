package racing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList = new ArrayList<>();
    private RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

    public void prepareCars(String[] carNames) {
        String[] carNameArr = carNames;
        for(String carName : carNameArr) {
           Car car = new Car(carName);
           carList.add(car);
        }
    }

    public void prepareCars(List<Car> cars) {
        carList = cars;
    }

    public int getMaxDistance() {
        return carList.stream()
                .max(Comparator.comparing(Car::totalDistance))
                .get()
                .totalDistance();
    }

    public List<Car> findWinners() {
        int maxDistance = getMaxDistance();
        List<Car> cars = carList.stream()
                .filter(car -> car.validDistance(maxDistance))
                .collect(Collectors.toList());
        return cars;
    }

    public List<Car> carsMove() {
        carList.forEach(car -> car.run(randomMovingStrategy));
        return carList;
    }

}
