package car.racing;

public class Car {

    private static final String DELIMITER = " : ";

    private final StringBuilder forwardStrBuilder;

    private int forwardCount = 0;
    private String name = "";

    public Car(String name) {
        this.name = name;
        this.forwardStrBuilder = new StringBuilder(name + DELIMITER);
    }

    public String forwardResult() {
        return forwardStrBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward(String forward) {
        forwardStrBuilder.append(forward);
        forwardCount++;
    }
}
