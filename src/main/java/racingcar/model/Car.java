package racingcar.model;

public class Car implements Comparable<Car>{

    public static final int RUNNING_CONDITION = 4;
    public static final int DEFAULT_POSITION = 1;

    private String name;
    private int position;

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        CarValidator.validate(name);
        return new Car(name, DEFAULT_POSITION);
    }

    int move(int power) {
        if(isRunning(power)){
            position++;
        }
        return position;
    }

    private boolean isRunning(int power) {
        return RUNNING_CONDITION <= power;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(position, other.position);
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position + '}';
    }
}
