package racinggamewinner.domain;


import racinggamewinner.random.NumberGenerator;

import java.util.*;

public class Cars {

    private List<Car> cars;


    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public static Cars registerCars(String carNames) {
        List<String> carNamesList = List.of(carNames.split(","));
        List<Car> cars = createCarList(carNamesList);
        checkNameLength(cars);
        return new Cars(cars);
    }

    private static List<Car> createCarList(List<String> carNamesList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNamesList) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private static void checkNameLength(List<Car> cars) {
        for (Car car : cars) {
            car.checkNameLength();
        }
    }

    public int carCount() {
        return cars.size();
    }

    public void raceOneRound(NumberGenerator numberGenerateStrategy) {
        recordEachRoundMoving(numberGenerateStrategy);
    }

    public void recordEachRoundMoving(NumberGenerator numberGenerateStrategy) {
        for (Car car : cars) {
            car.updatePosition(car.decideGoStop(numberGenerateStrategy.executeStrategy()));
        }
    }

    public Map<String, Integer> carNameAndPositions() {
        Map<String, Integer> carNamePosition = new LinkedHashMap<>();
        for (Car car : cars) {
            carNamePosition.put(car.carName(), car.currentPosition());
        }
        return carNamePosition;
    }


    public List<String> findWinner() {
        Winners winners = new Winners(this);
        return winners.findWinner();
    }


    public int maxCarPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::currentPosition))
                .map(Car::currentPosition)
                .orElse(0);
    }
}
