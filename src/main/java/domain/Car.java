package domain;

public class Car {

    private final Position position;
    private final CarName carName;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void move(int diceResult) {
        this.position.move(diceResult);
    }

    public int currentPosition() {
        return this.position.currentPosition();
    }

    public String name() {
        return carName.name();
    }

}
