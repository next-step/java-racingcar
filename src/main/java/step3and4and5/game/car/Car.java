package step3and4and5.game.car;

import step3and4and5.client.number.Number;

import java.util.Objects;

public final class Car {

    private static final int NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD = 4;

    private final Name name;

    private final Number number;

    private final Position position;

    private Car(Name name, Number number, Position position) {
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public Car movedCar() {
        if (number.generatedNumber() >= NUMBER_OF_JUDGMENT_THAT_CAN_GO_FORWARD) {
            return new Car(name, number, position.movedPosition());
        }
        return this;
    }

    public String print() {
        return name.print() + position.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public static class Factory {

        private final Number number;

        private final Position position;

        private final Name.Factory nameFactory;

        public Factory(Number number, String name) {
            this(number, new Position(0), new Name.Factory(name));
        }

        public Factory(Number number, Position position, String name) {
            this(number, position, new Name.Factory(name));
        }

        public Factory(Number number, Position position, Name.Factory nameFactory) {
            this.number = number;
            this.position = position;
            this.nameFactory = nameFactory;
        }

        public Car car() {
            return new Car(nameFactory.name(), number, position);
        }
    }
}
