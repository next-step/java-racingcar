package racingcar;

import exception.TooLongException;
import util.RandomGenerator;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final int MOVING_STANDARD = 4;
    private static final int NAME_LENGTH_STANDARD = 5;
    private final String carName;
    private int distance;

    public Car(String carName) {
        validateCarName(carName);
        this.distance = INITIAL_DISTANCE;
        this.carName = carName;
    }

    public Car(int distance, String carName) {
        validateCarName(carName);
        this.distance = distance;
        this.carName = carName;
    }

    public void move(RandomGenerator randomGenerator) {
        if (randomGenerator.generate() >= MOVING_STANDARD) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isWinner(int distance) {
        return distance == this.distance;
    }

    private void validateCarName(String carName){
        if(carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름으로 빈 값을 넣을 수 없습니다.");
        }
        if(carName.length() > NAME_LENGTH_STANDARD) {
            throw new TooLongException("자동차 이름은 5자를 초과할 수 없다. carName.length :" + carName.length());
        }
    }
}
