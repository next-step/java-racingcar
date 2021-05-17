package racing;

public class Car implements Comparable<Car> {
    private final int MAXIMUM_NAME_LENGTH = 5;
    private String name;
    private int movingRange;

    public Car(String name, int movingRange) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 .");
        }
        this.name = name;
        this.movingRange = movingRange;
    }

    public Car(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getMovingRange() {
        return movingRange;
    }

    public void moved() {
        movingRange += 1;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.movingRange, movingRange);
    }
}
