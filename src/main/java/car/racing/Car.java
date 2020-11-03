package car.racing;

public class Car {

    private static final String FORWARD = "-";

    private final Forwardable forwardable;
    private final StringBuilder forwardStrBuilder = new StringBuilder();

    public Car(Forwardable forwardable) {
        this.forwardable = forwardable;
    }

    public String forwardResult() {
        return forwardStrBuilder.toString();
    }

    public void forwardOrNot() {
        if (forwardable.forwardable()) {
            forwardStrBuilder.append(FORWARD);
        }
    }
}
