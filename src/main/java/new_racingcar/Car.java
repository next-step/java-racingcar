package new_racingcar;

public class Car {

    private MoveStrategy moveStrategy;
    private int distance;

    public Car(MoveStrategy moveStrategy) {
        this(moveStrategy, 0);
    }

    public Car(MoveStrategy moveStrategy, int distance) {
        this.distance = distance;
        this.moveStrategy = moveStrategy;
    }

    public Car move(int RandomValue) {
        if (moveStrategy.isMove(RandomValue)) {
            ++distance;
        }

        return new Car(this.moveStrategy, distance);
    }

    public int getDistance() {
        return distance;
    }
}
