package car;

public class Car {
    private int position = 0;
    private final static int BASE_NUMBER = 4;

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isAtLeastBaseNumber(int number) {
        return BASE_NUMBER <= number;
    }
}
