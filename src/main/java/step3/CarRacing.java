package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private final List<Car> cars;

    public CarRacing(String carNameString) {
        this.cars = new ArrayList<>();

        String[] carNameArray = getCarNameListSplit(carNameString);

        for (String s : carNameArray) {
            cars.add(new Car(s));
        }
    }

    private String[] getCarNameListSplit(String carNameList) {
        return carNameList.split(",");
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> racing(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(CarUtils.getNumberForMovement());
        }
        return cars;
    }

    public String extractWinner(List<Car> cars) {
        int maxMoveDistance = getMaxMoveDistance(cars);
        return cars.stream()
                .filter(o -> o.getMoveDistance() == maxMoveDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
    }

    private int getMaxMoveDistance(List<Car> cars) {
        int maxMoveDistance = 0;
        for (Car car : cars) {
            maxMoveDistance = compareMoveDistance(maxMoveDistance, car);
        }
        return maxMoveDistance;
    }

    private int compareMoveDistance(int maxMoveDistance, Car car) {
        return Math.max(car.getMoveDistance(), maxMoveDistance);
    }
}
