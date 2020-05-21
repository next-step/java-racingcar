package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Racingcar implements Comparable<Racingcar> {

    private static final int GO_CONDITION_COUNT = 4;
    private static final int RANDOM_BOUNDARY = 10;
    private static final String POSITION_BAR = "-";

    private int carNumber;
    private String carName;
    private int carMovePosition = 0;
    private int round = 0;
    private Map<Integer, Integer> saveRoundResultPosition = new HashMap<>();

    @Override
    public int compareTo(Racingcar racingcar) {
        return Integer.compare(racingcar.getCarMovePosition(), this.carMovePosition);
    }

    public Racingcar(int carNumber, String carName) {
        this.carName = carName;
        this.carNumber = carNumber;
    }

    public void moveCarMovePosition(Random random) {
        if (random.nextInt(RANDOM_BOUNDARY) > GO_CONDITION_COUNT) {
            this.carMovePosition++;
        }
        saveRoundResultPosition.put(this.round++, this.carMovePosition);
        printCarNowRoundPosition();
    }

    public void printCarRoundPosition(int round) {
        validRound(round);

        StringBuffer carPosition = new StringBuffer();
        int roundPosition = saveRoundResultPosition.get(round);
        for (int i = 0; i < roundPosition; i++) {
            carPosition.append(POSITION_BAR);
        }
        System.out.println(carName + " : " + carPosition.toString());
    }

    public void printCarNowRoundPosition() {
        StringBuffer carPosition = new StringBuffer();
        int roundPosition = saveRoundResultPosition.get(this.round-1);
        for (int i = 0; i < roundPosition; i++) {
            carPosition.append(POSITION_BAR);
        }
        System.out.println(carName + " : " + carPosition.toString());
    }

    private void validRound(int round) {
        if (this.round < round) {
            throw new NullPointerException("진행 되지 않은 라운드 입니다.");
        }
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


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

}
