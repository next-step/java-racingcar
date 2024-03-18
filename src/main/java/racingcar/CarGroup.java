package racingcar;

import java.util.ArrayList;

public class CarGroup {
    private ArrayList<Car> carGroup;

    public CarGroup(int numberOfCar) {
        carGroup = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            carGroup.add(new Car());
        }
    }

    public void updateCarArrayPosition() {
        for (int i = 0; i < carGroup.size(); i++) {
            carGroup.get(i).updatePosition();
        }
    }

    public int carGroupSize() {
        return carGroup.size();
    }

    public int position(int carIndex) {
        return carGroup.get(carIndex).position();
    }
}
