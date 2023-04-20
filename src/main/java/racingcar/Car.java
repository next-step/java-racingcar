package racingcar;

public class Car extends MoveContext {
    private final String name;
    private Integer position = 0;

    public Car(String name, MoveStrategy moveStrategy) {
        super(moveStrategy);
        validateCarName(name);
        this.name = name;
    }

    public void move(Integer number) {
        if (moveStrategy.isMovable(number)) {
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
