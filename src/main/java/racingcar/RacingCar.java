package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    static int numberOfCar;
    static List<String> carStatus;

    public RacingCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
        this.carStatus = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            carStatus.add(i, "");
        }
    }

    public int randomNumber() {
        return (int) (Math.random() * 10);
    }

    public String goStop(int randomNum) {
        if (randomNum >= 4) {
            return "-";
        }
        return "";
    }

    public List<String> carMoving() {
        for (int i = 0; i < numberOfCar; i++) {
            carStatus.set(i, carStatus.get(i) + goStop(randomNumber()));
        }
        return carStatus;
    }
}
