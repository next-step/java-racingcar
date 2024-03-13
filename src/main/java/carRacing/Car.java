package carRacing;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVE_STANDARD) {
            this.position += MOVE_DISTANCE;
        }
    }
    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }
}
