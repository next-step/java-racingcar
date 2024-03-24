package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGroup {

    private static final Random RANDOM = new Random();
    private final List<Car> carGroup;

    public CarGroup(List<String> names) {
        String[] splitNames = names.toArray(new String[names.size()]);
        carGroup = new ArrayList<>();
        for (String name : splitNames) {
            carGroup.add(new Car(name));
        }
    }

    public Car car(int carIndex) {
        return carGroup.get(carIndex);
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
        int randomValueBound = 10;
        for (Car car : carGroup) {
            int randomValue = RANDOM.nextInt(randomValueBound);
            car.updatePosition(randomValue);
        }
    }

    public void addCarToListIfThisPositionIsMatch(Car car, int position, List<String> winnerNames) {
        if (car.isMatch(position)) {
            winnerNames.add(car.name());
        }
    }

    public List<String> findWinners() {
        int maxPosition = 0;
        for (Car car : carGroup) {
            maxPosition = car.max(maxPosition);
        }

        List<String> winnerNames = new ArrayList<>();
        for (Car car : carGroup) {
            addCarToListIfThisPositionIsMatch(car, maxPosition, winnerNames);
        }

        return winnerNames;
    }
}
