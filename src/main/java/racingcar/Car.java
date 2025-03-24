package racingcar;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String input) {
        this.name = new Name(input);
        this.position = new Position();
    }

    public void move(NumberBasedCarMover carMover) {
        position.increase(carMover.move());
    }

    public String name() {
        return this.name.toString();
    }

    public int position() {
        return this.position.toInt();
    }
}
