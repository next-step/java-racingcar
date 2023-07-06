package racing.model;

public class Car {

    private static final int DEFAULT_CRITERION = 4;
    private static final int DEFAULT_POSITION = 1;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public void moveByRandomValue(int randomValue) {
        if (DEFAULT_CRITERION <= randomValue) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }

}
