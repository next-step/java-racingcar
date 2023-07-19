package study.racinggame.domain;

public class Car {
    private int position;
    private Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        this.position++;
    }

    public boolean isHigherPosition(int another) {
        return position > another;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
