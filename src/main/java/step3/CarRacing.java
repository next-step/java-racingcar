package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class CarRacing {

    private final List<Car> cars;

    public CarRacing(String carNameString) {
        this.cars = new ArrayList<>();

        String[] carNameArray = getCarNameListSplit(carNameString);

        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }
    }

    private String[] getCarNameListSplit(String carNameList) {
        String[] carNameListSplit = carNameList.split(",");
        return carNameListSplit;
    }

    public List<Car> racing() {
        for (Car car : cars) {
            car.moveForward(CarUtils.getNumberForMovement());
        }
        return cars;
    }

    public String extractWinner() {
        int maxMoveDistance = getMaxMoveDistance();
        return cars.stream().filter(o->o.getMoveDistance()==maxMoveDistance).map(Car::getCarName).collect(Collectors.joining(","));
    }

    private int getMaxMoveDistance() {
        int maxMoveDistance = 0;
        for (Car car : cars) {
            if(car.getMoveDistance() >= maxMoveDistance) {
                maxMoveDistance = car.getMoveDistance();
            }
        }
        return maxMoveDistance;
    }
}
