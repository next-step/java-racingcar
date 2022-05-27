package racingcar.domain;

public class Car {
    private static final int STANDARD_NUMBER = 4;
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= STANDARD_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

}

