package racing.dto;

public class Car {
    private String carName;
    private int movePosition;

    public Car(String carName, int movePosition) {
        this.carName = carName;
        this.movePosition = movePosition;
    }

    public void move() {
        movePosition++;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getMovePosition() {
        return this.movePosition;
    }
}