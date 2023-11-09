package racing.domain.car;


import java.util.Objects;

public class Car {

    private final Name name;
    private final static int THRESHOLD = 4;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

    public void move(int input) {
        if (isOverThreshHold(input)) {
            Position currentPosition = this.position();
            this.position = currentPosition.move(1);
        }
    }

    public boolean equalPosition(Position position) {
        return this.position.equals(position);
    }

    public boolean isForward(int position) {
        return position < this.position.position();
    }

    @Override
    public String toString() {
        return "Car{" +
            "name=" + name +
            ", position=" + position +
            '}';
    }

    private boolean isOverThreshHold(int input) {
        return THRESHOLD <= input;
    }


    public static class Name {

        private static final int NAME_LENGTH_LIMIT = 5;
        private final String name;

        public Name(String name) {
            this.validateNameLength(name);
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Name name1 = (Name) o;
            return Objects.equals(name, name1.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public String toString() {
            return this.name;
        }

        private void validateNameLength(String name) {
            boolean overNameLengthLimit = NAME_LENGTH_LIMIT < name.length();
            if (overNameLengthLimit) {
                throw new ValidationException("name can't over 5 letters");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name)
            && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, THRESHOLD, position);
    }
}
