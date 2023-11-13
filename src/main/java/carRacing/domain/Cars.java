package carRacing.domain;

import carRacing.util.MoveStrategy;
import carRacing.util.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] nameArray, MoveStrategy moveStrategy) {
        this.cars = makeCarList(nameArray, moveStrategy);
    }

    private List<Car> makeCarList(String[] nameArray, MoveStrategy moveStrategy) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameArray) {
            carList.add(new Car(name, moveStrategy));
        }
        return carList;
    }

    public List<Car> getCarsForPrint() {
        return Collections.unmodifiableList(cars);
    }


    public void move(NumberGenerator numberGenerator) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(numberGenerator.generate());
        }
    }

    public List<String> findWinners() {
        List<String> result = new ArrayList<>();
        int maxPosition = findMaxPosition();

        for (Car car : cars) {
            addWinner(maxPosition, result, car);
        }

        return result;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.findGreaterNumber(maxPosition);
        }

        return maxPosition;
    }

    private void addWinner(int maxPosition, List<String> result, Car car) {
        if (car.isSamePosition(maxPosition)) {
            result.add(car.getName());
        }
    }


}
