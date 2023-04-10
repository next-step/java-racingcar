package racing;

public class Car {

    public static final int START_POSITION = 1;
    private Integer position = START_POSITION;

    public Car() {
    }

    public void move(MoveStrategy moveStrategy) {
        position += moveStrategy.move();
    }

    public Integer getMove() {
        return this.position;
    }

}
