package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGroup {

    private List<Car> carGroup;

    public CarGroup(String[] names) {
        carGroup = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            carGroup.add(new Car(names[i]));
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
        return carGroup.get(carIndex).name();
    }

    public void updateCarGroupPosition() {
        Random random = new Random();
        int randomValue;
        for (int i = 0; i < carGroup.size(); i++) {
            randomValue = random.nextInt(10);
            carGroup.get(i).updatePosition(randomValue);
        }
    }
}
