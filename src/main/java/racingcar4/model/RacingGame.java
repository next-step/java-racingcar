package racingcar4.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int NAME_LENGTH_MAXIMUM = 5;
    private final List<Car> cars;

    public RacingGame(String nameOfCars) {
        String[] nameOfCarsList = splitNames(nameOfCars);
        this.cars = new ArrayList<>(nameOfCarsList.length);
        for (String name : nameOfCarsList) {
            carNameTest(name);
            cars.add(new Car(name));
        }
    }

    public void oneTurn() {
        for (Car car:cars) {
            car.carTurn();
        }
    }

    public String[] splitNames(String names) {
        return names.split(",");
    }

    public void carNameTest(String name) {
        if (name.length() > NAME_LENGTH_MAXIMUM) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int[] getCarsPosition() {
        int[] carsPosition = new int[cars.size()];

        for (int cnt=0; cnt < cars.size(); cnt++) {
            carsPosition[cnt] = cars.get(cnt).getPosition();
        }
        return carsPosition;
    }
}
