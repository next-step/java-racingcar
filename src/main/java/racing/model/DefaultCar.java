package racing.model;

import racing.strategy.DefaultCarMoveStrategy;

public class DefaultCar extends Car{
    private String tireMark = "-";
    public DefaultCar() {
        this(new CarPosition(1));
    }
    public DefaultCar(CarPosition position) {
        super(position);
    }

    @Override
    public void setDefaultCarMoveStrategy() {
        super.setStrategy(new DefaultCarMoveStrategy());
    }

    @Override
    public String getTireMark() {
        return tireMark;
    }
}
