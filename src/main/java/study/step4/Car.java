package study.step4;

public class Car {

    private final CarName name;

    private int position = 1;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isForwardCondition(number)) {
            forward();
        }
    }

    private boolean isForwardCondition(int number) {
        return number >= 4;
    }

    private void forward() {
        position += 1;
    }
}
