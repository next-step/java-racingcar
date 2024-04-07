package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> cars;

    public Cars(String[] strArr) {
        cars = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            cars.add(new Car(strArr[i], 0));
        }
    }

    public String judgeWinner(List<Car> cars) {
        int maxPosition = getMaxPosition();
        StringBuilder winnerNames = new StringBuilder();

        for (Car car : cars) {
            selectWinnerName(winnerNames, car, maxPosition);
        }
        return winnerNames.toString();
    }

    private void selectWinnerName(StringBuilder winnerNames, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winnerNames.append(car.getCarName()).append(" ");
        }
    }

    public void validateCar(List<Car> input) {
        Set<String> set = new HashSet<>();

        for (Car car : input) {
            set.add(car.getCarName());
        }

        if (input.size() != set.size()) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}