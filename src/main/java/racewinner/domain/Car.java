package racewinner.domain;

public class Car {
    private final Name name;
    private int position = 0;
    private final static String STEP_STRING = "-";


    public Car(final String name) {
        this.name = new Name(name);
    }

    public void move(final int number) {
        if (number >= 4) {
            position++;
        }
    }

    public int currentStep() {
        return position;
    }

    public String name() { return name.get(); }

    @Override
    public String toString() {
        return String.format("%s : %s", name.get(), STEP_STRING.repeat(position));
    }

}
