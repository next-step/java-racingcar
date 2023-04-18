package racing;

public class Car {

    public static final int START_POSITION = 0;
    public static final int MOVE_DISTANCE = 1;

    private final String name;
    private Integer position = START_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position += MOVE_DISTANCE;
        }
    }

    public CarDTO getCarDTO() {
        return new CarDTO(name, this.position);
    }

}
