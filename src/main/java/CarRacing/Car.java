package CarRacing;

public class Car {

    private String number;
    private Position position;

    public Car(String number, Position position) {
        this.number = number;
        this.position = position;
    }

    public void move(Direction direction) {
        direction.exec(this.position);
    }

    public Position getPosition() {
        return position;
    }
}
