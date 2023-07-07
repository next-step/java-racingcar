package racingcar;

import java.text.MessageFormat;

public class Car {

    public static final String DASH = "-";

    private static final int MINIMUM_POWER = 4;

    private String name;

    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String statusToString() {
        return MessageFormat.format("{0} : {1}", name, DASH.repeat(position));
    }

    public void move(int power) {
        if (movable(power)) {
            this.forward();
        }
    }

    private boolean movable(int power) {
        return power >= MINIMUM_POWER;
    }

    private void forward() {
        this.position++;
    }

    public boolean matchPosition(int otherPosition) {
        return position == otherPosition;
    }
}
