package racingcar.domain;

public class Car {
    private final Position position;

    private Car(Position position) {
        this.position = position;
    }

    public static Car create() {
         return new Car(Position.init());
    }

    public void move(int number) {
        this.position.move(number);
    }

    public Position position() {
        return this.position;
    }
}
