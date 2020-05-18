package step4;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go() {
        this.position++;
    }

    @Override
    public int compareTo(Car car) {
        if (this.position < car.getPosition()) {
            return 1;
        } else if (this.position > car.getPosition()) {
            return -1;
        }
        return 0;
    }
}
