package step4racinggamewinner;


import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final int MAX_CARNAME_LENGTH = 5;
    public static final int GO = 1;
    public static final int STOP = 0;
    private List<Car> cars;

    public Cars() {
    }

    public Cars(String carNames) {
        cars = new ArrayList<>();
        List<String> carNamesList = List.of(carNames.split(","));

        checkNameLength(carNamesList);
        registCars(carNamesList);
    }

    private void registCars(List<String> carNamesList) {
        carNamesList.stream().map(Car::new).forEachOrdered(car -> cars.add(car));
    }

    public void checkNameLength(List<String> carNamesList) {
        carNamesList.stream().filter(carName -> carName.length() > MAX_CARNAME_LENGTH).forEachOrdered(carName -> {
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
            int randomNumber = randomGenerator.generateRandomNumber();
            car.updateMovement(decideGoStop(randomNumber));
        }
    }


    public List<Integer> currentCarMovement() {
        List<Integer> movementList = new ArrayList<>();
        for (Car car : cars) {
            movementList.add(car.currentMovement());
        }
        return movementList;
    }
}
