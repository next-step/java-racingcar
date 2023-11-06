package racewinner;

public class Car {
    private final String name;
    private int position = 0;
    private final static String STEP_STRING = "-";


    public Car(final String name) {
        this.name = name;
    }

    public void move(final int number) {
        if (number >= 4) {
            position++;
        }
    }

    public int currentStep() {
        return position;
    }

    public String name() { return name; }

    @Override
    public String toString() {
        return String.format("%s : %s", name, STEP_STRING.repeat(position));
    }

}
