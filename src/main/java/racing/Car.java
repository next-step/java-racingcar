package racing;

public class Car implements Comparable{

    private static final int MOVING_STANDARD_VALUE = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void addPosition(int randomValue) {
        if (randomValue < MOVING_STANDARD_VALUE) {
            return;
        }
        ++position;
    }

    @Override
    public int compareTo(Object o) {
        Car otherCar = (Car)o;
        if (this.getPosition() > otherCar.getPosition())
            return -1;
        if (this.getPosition() < otherCar.getPosition())
            return 1;
        return 0;
    }
}