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
        cars = new ArrayList<>(carList);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getList() {
        return cars;
    }

    public void playRound(Movable movable) {
        for (Car car : cars) {
            car.moveByCondition(movable.isMovable());
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
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }
}
