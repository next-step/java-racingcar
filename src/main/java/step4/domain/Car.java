package step4.domain;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move() {
        this.position = position.move();
    }
}
