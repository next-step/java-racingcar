package racingcar;

import util.CommonUtil;

import java.util.HashMap;
import java.util.Map;

public class Racingcar {

    private static final int GO_CONDITION_COUNT = 4;
    private static final int RANDOM_BOUNDARY = 10;

    private int carNumber;
    private String carName;
    private int carMovePosition = 0;
    private Map<Integer, Integer> saveRoundResultPosition = new HashMap<>();

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarMovePosition(int carMovePosition) {
        this.carMovePosition = carMovePosition;
    }

    public Racingcar(int carNumber, String carName) {
        this.carName = carName;
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarMovePosition() {
        return carMovePosition;
    }

    public void moveCarMovePosition(int round) {
        if (CommonUtil.randomNumber(RANDOM_BOUNDARY) > GO_CONDITION_COUNT) {
            this.carMovePosition++;
        }
        saveRoundResultPosition.put(round, this.carMovePosition);
    }

    public void printCarPrintRoundPosition(int round, String expressionWord) {
        StringBuffer carPosition = new StringBuffer();
        int roundPosition = saveRoundResultPosition.get(round);
        for (int i = 0; i < roundPosition; i++) {
            carPosition.append(expressionWord);
        }
        System.out.println(carName + " : " + carPosition.toString());
    }
}
