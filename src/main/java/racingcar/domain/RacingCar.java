package racingcar.domain;

public class RacingCar implements Car {
    private int position = 0;
    private final String name;
    private final Engine engine;

    public RacingCar(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    @Override
    public void move() {
        if(engine.isMove()){
            position++;
        }
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}