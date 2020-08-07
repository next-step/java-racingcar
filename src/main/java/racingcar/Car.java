package racingcar;

public class Car implements Comparable<Car> {
    private static final int THRESHOLD = 4;
    private static final int START_POINT = 1;

    private int position;
    private String name;

    private Car(String name) {
        this.position = START_POINT;
        this.name = name;
    }

    public void move(int fuel) {
        if (fuel >= THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    @Override
    public int compareTo(Car other) {
        return this.getPosition() - other.getPosition();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
