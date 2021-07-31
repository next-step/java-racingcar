package racing.model;

import racing.util.RandomUtil;
import racing.view.RacingView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList = new ArrayList<>();

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

    public List<Car> winner() {
        int maxDistance = getMaxDistance();
        List<Car> cars = carList.stream()
                .filter(car -> car.checkDistance(maxDistance))
                .collect(Collectors.toList());
        return cars;
    }

    public void carsMove() {
        carList.forEach(car -> car.run(RandomUtil.randomValue()));
        RacingView.printCarMove(carList);
    }
}
