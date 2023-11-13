package study.step5.domain;

public class Car {

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public String name() {
        return name.getName();
    }

    public Position position() {
        return position;
    }

    public void move(int number) {
        if (isForwardCondition(number)) {
            position.forward();
        }
    }

    private boolean isForwardCondition(int number) {
        return number >= 4;
    }

    public boolean isWinner(int maxPosition) {
        return position.getPosition() == maxPosition;
    }
}
