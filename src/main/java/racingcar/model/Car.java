package racingcar.model;

import racingcar.util.Message;
import racingcar.util.RandomGenerator;

public class Car {

    private String carName;
    private String position;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = "";
    }

    public void moveForward() {
        RandomGenerator randomGenerator = new RandomGenerator();
        int randomNumber = randomGenerator.generateRandomNumber();
        //System.out.println(randomNumber);
        if (randomNumber >= 4) {
            this.position += "-";
        }

    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(Message.CAR_NAME_ERROR);
        }
    }

    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }
}
