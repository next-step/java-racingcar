package racingcar.application;

public class RacingCarView {
    private final int id;
    private final int position;

    public RacingCarView(final int id, final int position) {
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }
}
