package study.step4;

public class Car {

    private final String name;

    private int position = 1;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (isForwardCondition(number)) {
            forward();
        }
    }

    private static boolean isForwardCondition(int number) {
        return number >= 4;
    }

    private void forward() {
        position += 1;
    }
}
