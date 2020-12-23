package step3.domain;

import step3.domain.rule.MoveRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for(int i = 0; i < carNames.length; i++) {
            cars.add(createCar(carNames[i]));
        }
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }

    public void moveAll(int roundTime, MoveRule moveRule) {
        cars.forEach(car -> car.move(roundTime, moveRule.canMove()));
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<String>();

        for(Car car: cars) {
            addWinnerName(winnerNames, car);
        }
        return winnerNames;
    }

    private List<String> addWinnerName(List<String> winnerNames, Car car) {
        if(isWinner(car.getDistance())) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    private boolean isWinner(int position) {
        int winnerPosition = getMaxPosition(getFinalPositionList());

        if(winnerPosition == position) {
            return true;
        }
        return false;
    }

    private static int getMaxPosition(List<Integer> finalPositions) {
        return Collections.max(finalPositions);
    }

    private List<Integer> getFinalPositionList() {
        List<Integer> finalPositionList = new ArrayList<>();

        for(Car car: cars) {
            finalPositionList.add(car.getDistance());
        }
        return finalPositionList;
    }
}