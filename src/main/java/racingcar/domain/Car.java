package racingcar.domain;

import static racingcar.domain.ErrorMessage.EMPTY_NAME_ERROR;
import static racingcar.domain.ErrorMessage.INPUT_LENGTH_EXCEEDED_ERROR;
import static racingcar.view.ResultView.printCarName;
import static racingcar.view.ResultView.printGoDistance;

public class Car {

    private int distance = 0;
    private String carName = "";

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }


    public void goCar(int randomNum) {
        setGoCar(randomNum);
    }


    private void setGoCar(int randomNum) {
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
