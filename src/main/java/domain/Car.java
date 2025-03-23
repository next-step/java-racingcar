package domain;

public class Car {

    private Position position;
    private final CarName carName;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position(0);
    }

    public void move(int diceResult) {
        if (diceResult >= 4) {
            this.position = this.position.move();
        }
    }

    public int currentPosition() {
        return this.position.currentPosition();
    }

    public String name() {
        return carName.name();
    }

}
