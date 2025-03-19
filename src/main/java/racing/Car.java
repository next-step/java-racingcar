package racing;

public class Car {
    static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public void move(int diceValue) {
        if (diceValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
