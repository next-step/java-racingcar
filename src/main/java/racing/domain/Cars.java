package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cars {
    private List<Car> cars;

    public Cars(String[] nameList) {
        cars = new ArrayList<>();

        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public Cars(List<Car> carList) {
        cars = new ArrayList<>();

        for (Car car : carList) {
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
        RandomGenerator randomGenerator = new RandomGenerator(System.currentTimeMillis());

        for (Car car : cars) {
            car.moveByCondition(randomGenerator.nextInt());
        }
    }

    public String getWinnersName(String delimiter) {
        int maxPosition = maxPosition();

        StringJoiner stringJoiner = new StringJoiner(delimiter);

        for (Car car : cars) {
            addMaxCarName(maxPosition, stringJoiner, car);
        }

        return stringJoiner.toString();
    }

    private void addMaxCarName(int maxPosition, StringJoiner stringJoiner, Car car) {
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