package step4;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position++;
        }
    }

    int getPosition() {
        return this.position;
    }

    public StringBuilder getCurrentStatus() {
        return new StringBuilder()
                .append(name)
                .append(" : ")
                .append("-".repeat(position));
    }
}
