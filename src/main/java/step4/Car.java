package step4;

public class Car extends Moving implements Comparable<Car> {

    private String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go() {
        if (isMovable()) {
            this.position++;
        }
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
