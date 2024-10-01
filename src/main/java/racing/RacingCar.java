package racing;

public class RacingCar {
    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public RacingCar(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (moveStrategy.shouldMove()) {
            this.position++;
        }
    }
}
