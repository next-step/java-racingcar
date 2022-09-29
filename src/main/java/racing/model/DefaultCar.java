package racing.model;

import racing.strategy.DefaultCarMoveStrategy;

public class DefaultCar extends Car {
    private String tireMark = "-";
    private int speed = 1;

    public DefaultCar(String name, CarPosition position) {
        super(name, position);
    }

    public DefaultCar(String name) {
        super(name);
    }

    @Override
    public void setDefaultCarMoveStrategy() {
        super.setStrategy(new DefaultCarMoveStrategy());
    }

    @Override
    public String getTireMark() {
        return tireMark;
    }

    @Override
    public void move() {
        position.move(speed);
    }
}
