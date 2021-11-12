package racingcar.domain;


import racingcar.strategy.MovingStrategy;

public class Car {

    private int state;
    private String name;

    public Car() {
        this.state = 0;
    }

    public Car(String name) {
        this.state = 0;
        this.name = name;
    }

    public void increaseState(MovingStrategy randomMovingStrategy) {
        if (randomMovingStrategy.isMove()) {
            this.state++;
        }
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
