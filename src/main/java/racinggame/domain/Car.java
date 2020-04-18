package racinggame.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar(MoveStrategy moveStrategy) {
        if (moveStrategy.moveOrNot()) {
            this.position++;
        }
    }

    public boolean isInPosition(final int position) {
        return position == this.position;
    }

    @Override
    public Car clone() {
        return new Car(this.name, this.position);
    }
}
