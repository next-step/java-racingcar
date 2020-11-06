package car.racing;

import java.util.Random;

public class Car {

    private static final String FORWARD = "-";
    private static final int LIMIT = 10;

    private final Forwardable forwardable;
    private final StringBuilder forwardStrBuilder = new StringBuilder();
    private final Random random = new Random();

    public Car(Forwardable forwardable) {
        this.forwardable = forwardable;
    }

    public String forwardResult() {
        return forwardStrBuilder.toString();
    }

    public void forwardOrNot() {
        if (forwardable.forwardable(random.nextInt(LIMIT))) {
            forwardStrBuilder.append(FORWARD);
        }
    }
}
