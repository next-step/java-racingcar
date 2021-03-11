package racingcar;

public class Car {
    private String carName;
    private int position;

    public Car() {
        this("undefined");
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        this.position += 1;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            this.move();
        }
    }
}
