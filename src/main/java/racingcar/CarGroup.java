package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private List<Car> carGroup;

    public CarGroup(String[] carNames) {
        carGroup = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carGroup.add(new Car(carNames[i]));
        }
    }

    public Car car(int carIndex) {
        return carGroup.get(carIndex);
    }

    public List<Car> carGroup() {
        return carGroup;
    }

    public int size() {
        return carGroup.size();
    }

    public int position(int carIndex) {
        return carGroup.get(carIndex).position();
    }

    public String carName(int carIndex) {
        return carGroup.get(carIndex).carName();
    }

    public void updateCarArrayPosition(int randomValue) {
        for (int i = 0; i < carGroup.size(); i++) {
            carGroup.get(i).updatePosition(randomValue);
        }
    }
}
