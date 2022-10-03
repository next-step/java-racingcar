package racingCar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        this.cars = new ArrayList<>();
        String[] sCars = carNames.split(",");
        for (String sCar : sCars) {
            cars.add(new Car(sCar));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play(new Random());
        }
    }

    public List<String> getWinners() {
        int maxPos = getMaxPos();

        return cars.stream()
                .filter(car -> car.getPos() == maxPos)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getMaxPos() {

        return cars
                .stream()
                .mapToInt(car -> car.getPos())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

}
