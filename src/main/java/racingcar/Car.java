package racingcar;

import java.util.Random;

import static racingcar.ResultView.printCarName;
import static racingcar.ResultView.printGoDistance;

public class Car {
    private static final int RANDOM_SIZE = 10;
    public static final String INPUT_LENGTH_EXCEEDED_ERROR = "5자 초과하였습니다.";
    public static String EMPTY_NAME_ERROR = "이름이 없습니다.";
    private int distance = 0;
    private String carName = "";

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }


    public void goCar() {
        setGoCar(getRandomNum());
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_SIZE);
    }

    public void setGoCar(int randomNum) {
        if (randomNum >= 4) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEEDED_ERROR);
        } else if (carName.length() == 0) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    public int compareDistance(int maxDistance) {
        return Math.max(distance, maxDistance);
    }

    public boolean isWinnerCar(int maxDistance) {
        return distance == maxDistance;
    }

    public void printCarRaceResult() {
        printCarName(carName);
        for (int i = 0; i < distance; i++) {
            printGoDistance();
        }
    }
}
