package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MAX_RANDOM_VALUE = 10;
    private static final String CARS_NAME_DELIMITER = ",";

    private List<Car> cars;

    public Cars(String input) {
        cars = new ArrayList<>();

        for (String name : input.split(CARS_NAME_DELIMITER)) {
            cars.add(new Car(name));
        }
    }

    public Cars(List<Car> carsList) {
        cars = new ArrayList<>();

        for (Car car : carsList) {
            cars.add(car.copy());
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getList() {
        return cars;
    }

    public List<Integer> getCarsPositionList() {
        List<Integer> positionList = new ArrayList<>();

        for (Car car : cars) {
            positionList.add(car.getPosition());
        }

        return positionList;
    }

    public void playRound() {
        Random random = new Random(System.currentTimeMillis());

        for (Car car : cars) {
            car.moveByCondition(random.nextInt(MAX_RANDOM_VALUE));
        }
    }

    public String getWinnersName() {
        int maxPosition = maxPosition();

        return new String();
    }

    public int maxPosition() {
        return Integer.MIN_VALUE;
    }
}