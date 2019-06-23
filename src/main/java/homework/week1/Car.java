package homework.week1;

public class Car {

    private static final int MIN_MOVE_CONDITION_VALUE = 4;

    private String name;
    private int position;

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public Car(String name) {
        this.name = name;
    }

    void move(int value) {
        if (MIN_MOVE_CONDITION_VALUE <= value) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
