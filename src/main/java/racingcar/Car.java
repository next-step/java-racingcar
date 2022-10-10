package racingcar;

public class Car {
    private CarName name;
    private int position = 0;

    public Car() {}

    public Car(String name) {
        this.name = new CarName(name);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void forward() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }

    public boolean isPosition(int position) {
        return this.position == position;
    }
}
