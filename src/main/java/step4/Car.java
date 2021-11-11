package step4;

public class Car {

    private String name;
    private int position;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    private void validateName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        position = moveStrategy.move(position);
    }
}
