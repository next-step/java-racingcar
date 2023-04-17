package racingcar;

public class Car {
    private static final Integer MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;
    private Integer position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void move(Integer number) {
        if (isMovable(number)) {
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

    private static boolean isMovable(Integer number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }

    public boolean isPositionEqual(Integer position) {
        return this.position.equals(position);
    }
}
