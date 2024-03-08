package racing;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public String carPosition() {
        return position.dashOfPosition();
    }

    public void play(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.addOne();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car target = (Car) obj;
            return position.equals(target.position);
        }
        return false;
    }
}
