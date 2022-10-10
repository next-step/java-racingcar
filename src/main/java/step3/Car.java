package step3;

public class Car {

    private Name name;
    private Position position;
    private final int ADVANCED_VALUE = 4;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position advanceCar(int randomValue) {
        if (isAdvanced(randomValue)) {
            this.position.advancedPosition();
            return this.position;
        }
        return this.position;
    }

    public Position currentPosition() {
        return this.position;
    }

    public Name currentName() {
        return this.name;
    }

    private boolean isAdvanced(int value) {
        return value >= ADVANCED_VALUE;
    }

}
