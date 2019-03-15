package racingcar;

public class Car {

    private final String name;
    private int position;
    private static final int MOVE_THRESHOLD= 4;

    public Car(String name) {
        position = 0;
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void go(int randomValue) {
        if(randomValue >= MOVE_THRESHOLD)
        this.position++;
    }

    public boolean isEqualPosition(int position) {
        if(this.position == position)
            return true;

        return false;
    }
}