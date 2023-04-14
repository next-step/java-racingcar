package racing;

public class Car {

    public static final int START_POSITION = 0;
    public static final int MOVE_DISTANCE = 1;
    private Integer position = START_POSITION;

    public Car() {
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()){
            position += MOVE_DISTANCE;
        }
    }

    public CarDTO getCarDTO() {
        return new CarDTO(this.position);
    }

}
