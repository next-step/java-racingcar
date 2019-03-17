package racingcar;

public class Car implements Comparable<Car> {

    private static final int MOVE_THRESHOLD= 4;
    private final String name;
    private int position;

    public Car(String name) {
        position = 0;
        this.name = name;
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

    public void go(int randomValue) {
        if(randomValue >= MOVE_THRESHOLD)
        this.position++;
    }

    public int comparePosition(int position) {
        return this.position - position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}