package racing.application;

public class Car implements Comparable<Car> {
    private String name;
    private int position = 1;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.getPosition(), position);
    }
}
