package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    static int numberOfCar;
    static List<String> carStatus;
    List<Integer> carStatusNum;
    private Car car;

    public RacingCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
        this.carStatus = new ArrayList<>();
        this.carStatusNum = new ArrayList<>();
        car = new Car(numberOfCar);
        for (int i = 0; i < numberOfCar; i++) {
            carStatus.add(i, "");
        }
        for (int i = 0; i < numberOfCar; i++) {
            carStatusNum.add(i, 0);
        }
    }

    public int randomNumber() {
        return (int) (Math.random() * 10);
    }

    public int goStop(int randomNum) {
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
    }

    public List<String> carMoving() {
        List<Integer> carNowMove = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            int goStop = goStop(randomNumber());
            carNowMove.add(i, goStop);
        }
        carStatusNum = car.carMovingNum(carNowMove);
        for (int i = 0; i < numberOfCar; i++) {
            carStatus.set(i, carMovePrint(carStatusNum.get(i)));
        }
        return carStatus;
    }

    public String carMovePrint(int numberMoving) {
        String movePrint = "";
        for (int i = 0; i < numberMoving; i++) {
            movePrint += "-";
        }
        return movePrint;
    }
}
