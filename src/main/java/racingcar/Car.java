package racingcar;

public class Car {
    
    private static final int STANDARD_NUMBER = 4;

    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void moveOrStop() {
        if (moveForwardYn()) {
            increasePosition();
        }
    }

    public int getRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();
        return randomNumber.getRandomNumber();
    }

    public boolean moveForwardYn() {
        return getRandomNumber() >= STANDARD_NUMBER;
    }

    private void increasePosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}

