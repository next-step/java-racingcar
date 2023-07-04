package carracingfield;

import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import random.RandomGenerator;

public class CarRacingField {

    private List<Car> cars = new ArrayList<>();

    public CarRacingField(String a, String b, String c) {
        cars.add(new Car(a));
        cars.add(new Car(b));
        cars.add(new Car(c));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveOrStopByRandomValue(RandomGenerator.extractRandomSingleDigit());
        }
    }

    public List<Car> getWinners(List<Car> carList) {
        int maxPosition = carList.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new RuntimeException("자동차 리스트는 비어있을 수 없습니다."));

        return carList.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}
