package racingcar.application.response;

public class RacingCarView {
    private final String name;
    private final int position;

    public RacingCarView(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
