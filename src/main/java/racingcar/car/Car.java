package racingcar.car;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.position = new Position();
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void movePosition() {
        position.movePosition();
    }

    public void printCarStatus() {
        name.printCarName();
        position.printCarPosition();
    }
}
