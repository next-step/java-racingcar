package racingcar;


public class Car {

    private final MoveStrategy moveStrategy;
    private Integer distance = 0;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Integer getDistance(z) {
        return distance;
    }

    public void play() {
        if (moveStrategy.move()) {
            distance++;
        }
    }
}