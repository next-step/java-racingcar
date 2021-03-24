package carRacing.model;


public class Car {
    private final Name carName;
    private Position position;

    public Car() {
        this("car", 0);
    }

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = new Name(carName);
        this.position = new Position(position);
    }

    public void moveByRandomInt(int randomInt) {
        if (randomInt >= 4) {
            position.move();
        }
    }

    public int getPosition() {
        return this.position.value();
    }

    @Override
    public String toString() {
        return String.format("%5s : %s", carName, position);
    }

    public boolean isWinner(int maxScore) {
        return this.position.value() == maxScore;
    }

    public String getCarName() {
        return carName.toString();
    }
}
