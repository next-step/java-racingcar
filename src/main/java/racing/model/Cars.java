package racing.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public void prepareCars(String[] carNames) {
        String[] carNameArr = carNames;
        for(String carName : carNameArr) {
           Car car = new Car(carName, 0);
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

    public List<Car> findWinner() {
        int maxDistance = getMaxDistance();
        List<Car> cars = carList.stream()
                .filter(car -> car.validDistance(maxDistance))
                .collect(Collectors.toList());
        return cars;
    }

    public void carsMove() {
        carList.forEach(car -> car.run(() -> true));
    }

    public List<String> getCarMoveLines() {
        return this.carList
                .stream()
                .map(car -> car.getMoveLine())
                .collect(Collectors.toList());
    }
}
