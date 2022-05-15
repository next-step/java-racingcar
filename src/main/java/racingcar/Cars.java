package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String DEFAULT_DELIMITER = "[,]";
    private static final int MAX_LENGTH = 5;
    private static int maxPosition = 0;
    private StringBuilder stringBuilder = new StringBuilder();
    private List<Car> cars = new ArrayList<>();
    private String winner = "";

    public Cars(String inputNames) {
        makeCars(toArray(inputNames));
    }

    public String getWinner() {
        return winner;
    }

    public String[] toArray(String inputValue) {
        String[] inputValues = inputValue.split(DEFAULT_DELIMITER);
        return inputValues;
    }

    public void makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (checkLength(names[i])) {
                cars.add(new Car(names[i]));
            }
        }
    }

    public boolean checkLength(String carNames) {
        return carNames.length() <= MAX_LENGTH;
    }

    public void move() {
        cars.forEach(Car::moveOrStop);
        print();
    }

    public void print() {
        for (Car car : cars) {
            maxPosition = setMaxPosition(maxPosition, car.getPosition());
            System.out.println(car.getCarName() + " : " + append(car.getPosition()));
        }
        System.out.println("");
    }

    public int setMaxPosition(int tmpMax, int position) {
        return Math.max(tmpMax, position);
    }

    public static String append(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void saveWinnerCar() {
        for (Car car : cars) {
            if (isMaxPosition(car.getPosition())) {
                saveWinnerInfo(car.getCarName());
            }
        }
    }

    public boolean isMaxPosition(int position) {
        return maxPosition == position;
    }

    public void saveWinnerInfo(String carName) {
        if (winner != "") {
            stringBuilder.append(", ");
        }
        winner = stringBuilder.append(carName).toString();
    }
}
