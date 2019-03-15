package racingcar.domain;

public class RacingCar {
    private final Integer id;
    private final String name;
    private int position;

    public RacingCar(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
