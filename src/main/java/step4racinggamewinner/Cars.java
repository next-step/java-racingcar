package step4racinggamewinner;


import step4racinggamewinner.random.RandomGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    public static final int CARNAME_MAX_LENGTH = 5;
    public static final int GO = 1;
    public static final int STOP = 0;
    private List<Car> cars;

    public Cars() {
    }


    public Cars(String carNames) {
        cars = new ArrayList<>();
        List<String> carNamesList = List.of(carNames.split(","));
        checkNameLength(carNamesList);
        registerCars(carNamesList);
    }

    public Cars(Car... cars) {
        this.cars = List.of(cars);
    }

    protected Car baseLineCar() {
        return cars.get(0);
    }

    protected String specificCarName(int index) {
        return cars.get(index).carName();
    }

    private void registerCars(List<String> carNamesList) {
        carNamesList.stream()
                .map(Car::new)
                .forEachOrdered(car -> cars.add(car));
    }

    public void checkNameLength(List<String> carNamesList) {
        carNamesList.stream()
                .filter(carName -> carName.length() > CARNAME_MAX_LENGTH)
                .forEachOrdered(carName -> {
                    throw new IllegalArgumentException();
                });
    }

    public int carCount() {
        return cars.size();
    }

    public int decideGoStop(int randomNumber) {
        if (randomNumber >= 4) {
            return GO;
        }
        return STOP;

    }

    public void recordEachRoundMoving(RandomGenerator randomGenerator) {
        for (Car car : cars) {
            car.updatePosition(decideGoStop(randomGenerator.generateRandomNumber()));
        }
    }

    public void viewRacing(int movingTryCount, RandomGenerator randomGenerator) {
        for (int i = 0; i < movingTryCount; i++) {
            recordEachRoundMoving(randomGenerator);
            ResultView.printTotalCarPosition(carNameAndPosition());
        }

    }

    public Map<String, Integer> carNameAndPosition() {
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

    public List<Integer> currentCarPositionList() {
        List<Integer> movementList = new ArrayList<>();
        for (Car car : cars) {
            movementList.add(car.currentPosition());
        }
        return movementList;
    }

}
