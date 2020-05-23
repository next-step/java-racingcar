package study.racing.model;

public class Car implements Comparable<Car> {
    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if(canMove(value)) {
            position++;
        }
    }

    private boolean canMove(int value) {
        return value >= MOVE_THRESHOLD;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }
}
