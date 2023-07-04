package logic;

public class Car {

    private final int MOVING_LIMIT = 4;
    private String name;
    private int position = 0;


    public Car(String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException();
        }
    }

    public int move() {
        int randomNum = NumberGenerator.getRandomNumber();
        if (randomNum >= MOVING_LIMIT) {
            this.position++;
        }
        return randomNum;
    }

    public int getPosition() {
        return this.position;
    }

}
