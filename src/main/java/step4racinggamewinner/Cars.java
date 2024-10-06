package step4racinggamewinner;


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

    public Cars(List<Car> cars) {
        this.cars = cars;
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

    public void recordEachRoundMoving(int randomNumber) {
        for (Car car : cars) {
            car.updatePosition(decideGoStop(randomNumber));
        }
    }

    public void viewRacing(int movingTryCount, RandomGenerator randomGenerator) {
        for (int i = 0; i < movingTryCount; i++) {
            recordEachRoundMoving(randomGenerator.generateRandomNumber());
            ResultView.printCurrentCarPosition(currentCarNameAndPosition());
        }

    }

    public Map<String, Integer> currentCarNameAndPosition() {
        Map<String, Integer> carNamePosition = new LinkedHashMap<>();
        for (Car car : cars) {
            carNamePosition.put(car.carName(), car.currentPosition());
        }
        return carNamePosition;
    }

    public List<Integer> currentCarPositionList() {
        List<Integer> movementList = new ArrayList<>();
        for (Car car : cars) {
            movementList.add(car.currentPosition());
        }
        return movementList;
    }


    public List<String> findWinner() {

        List<Integer> positionList = currentCarPositionList();
        List<String> winnerNameList = new ArrayList<>();
        winnerNameList.add(cars.get(0).carName());
        int currentPosition = positionList.get(0);
        for (int i = 1; i < positionList.size(); i++) {
            if (currentPosition == positionList.get(i)) {
                winnerNameList.add(cars.get(i).carName());
            } else if (currentPosition < positionList.get(i)) {
                winnerNameList.clear();
                winnerNameList.add(cars.get(i).carName());
            }
        }
        return winnerNameList;

    }

}
