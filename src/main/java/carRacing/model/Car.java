package carRacing.model;


public class Car {
    private final Name carName;
    private Position position;

    public Car() {
        this("car");
    }

    public Car(String carName) {
        this.carName = new Name(carName);
        this.position = new Position(0);
    }

    public void moveByRandomInt(int randomInt) {
        if (randomInt >= 4) {
            position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return String.format("%5s : %s", carName, position);
    }

}
