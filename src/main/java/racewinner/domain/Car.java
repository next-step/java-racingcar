package racewinner.domain;

public class Car {
    private final Name name;
    private Position position;
    private final static String STEP_STRING = "-";


    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void move(final int number) {
        if (number >= 4) {
            position.move();
        }
    }

    public int currentStep() {
        return position.get();
    }

    public String name() { return name.get(); }

    @Override
    public String toString() {
        return String.format("%s : %s", name.get(), STEP_STRING.repeat(position.get()));
    }

}
