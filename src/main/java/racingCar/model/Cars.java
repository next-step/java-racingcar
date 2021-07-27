package racingCar.model;

import racingCar.utils.RandomUtil;
import racingCar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int playCount;

    public Cars(String[] carNames, int playCount) {
        this.cars = makeCars(carNames);
        this.playCount = playCount;
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(RandomUtil.getNumber());
            ResultView.printLocation(car);
        }
    }

    public void play() {
        for (int i = 0; i < playCount; i++) {
            moveCars();
            System.out.println();
        }
    }

    private int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.greaterThan(maxLocation);
        }
        return maxLocation;
    }

    public String findWinners() {
        int maxLocation = findMaxLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }
}
