package racingcar;

public class Car extends MoveContext {
    private final String name;
    private Integer position;

    public Car(String name, MoveStrategy moveStrategy, Integer position) {
        super(moveStrategy);
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public Car(String name, MoveStrategy moveStrategy) {
        this(name, moveStrategy, 0);
    }

    public Car(String name, Integer position) {
        this(name, new RandomMoveStrategy(), position);
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public CarDto toDto() {
        return new CarDto(this.name, this.position);
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Invalid Car Name: " + name);
        }
    }

    public boolean isPositionEqual(Integer position) {
        return this.position.equals(position);
    }
}
