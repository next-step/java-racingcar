package racingcar.domain;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name, Position position) {
        this.position = position;
        this.name = name;
    }

    public static Car create(String name) {
         return new Car(name, Position.init());
    }

    public void move(int number) {
        this.position.move(number);
    }

    public String name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }
}
