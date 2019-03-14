package racingcar.domain;

public class RacingCar {
    private final Integer id;
    private int position;

    public RacingCar(final Integer id) {
        this.id = id;
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public Integer getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }
}
