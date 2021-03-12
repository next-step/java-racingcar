package step3;

public class Car implements Comparable {

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public boolean isMove(int randomValue, int limit) {
        return randomValue >= limit;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        if (this.position > car.getPosition()) {
            return 1;
        } else if (this.position < car.getPosition()) {
            return -1;
        }
        return 0;
    }
}
