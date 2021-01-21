package racingcar.domain;

public class RacingCar implements Car {
    private int position = 0;
    private String name;
    private Engine engine;

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
    public void printCurrentPosition() {
        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
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