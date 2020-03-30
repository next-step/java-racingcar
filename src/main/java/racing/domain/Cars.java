package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Cars {
    private static final int MAX_RANDOM_VALUE = 10;
    private static final String CARS_NAME_DELIMITER = ",";

    private List<Car> cars;
    private int maxPosition;

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
        maxPosition = maxPosition();

        StringJoiner stringJoiner = new StringJoiner(CARS_NAME_DELIMITER);

        for (Car car : cars) {
            addMaxCarName(stringJoiner, car);
        }

        return stringJoiner.toString();
    }

    private void addMaxCarName(StringJoiner stringJoiner, Car car) {
        if (car.isSamePosition(maxPosition)) {
            stringJoiner.add(car.getName());
        }
    }

    public int maxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            int position = car.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }

        return maxPosition;
    }
}