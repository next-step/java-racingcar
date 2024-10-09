package racingcar;

public class RacingResult {

    private final String name;
    private final int position;

    public RacingResult(String name, int position) {
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
