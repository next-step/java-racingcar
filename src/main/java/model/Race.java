package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Race {

    private List<Car> cars;

    public Race() {
        cars = new ArrayList<>();
    }

    public void resetWithCarsOf(List<String> namesOfCars) {
        cars = new ArrayList<>();
        createCars(namesOfCars);
    }

    public void progress(MoveStrategy moveStrategy) {
        for (var car : cars) {
            car.moveWithStrategy(moveStrategy);
        }
    }

    public Map<String, Integer> getCarPositions() {
        var carPositions = new LinkedHashMap<String, Integer>();
        for (var car : cars) {
            carPositions.put(car.getName(), car.getPosition());
        }
        return carPositions;
    }

    public Set<String> getWinnerNames() {
        int winnerPosition = getWinnerPosition();
        WinnerInfo winnerInfo = new WinnerInfo(winnerPosition);
        for (Car car : cars) {
            winnerInfo.addWinnerIfMatchingPosition(car);
        }
        return winnerInfo.getWinnerNames();
    }

    private int getWinnerPosition() {
        var winnerPosition = 0;
        for (var car : cars) {
            winnerPosition = Math.max(car.getPosition(), winnerPosition);
        }
        return winnerPosition;
    }

    private void createCars(List<String> namesOfCars) {
        for (var name : namesOfCars) {
            cars.add(new Car(name));
        }
    }
}
