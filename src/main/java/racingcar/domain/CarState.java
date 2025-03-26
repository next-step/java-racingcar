package racingcar.domain;

public class CarState {
    private final String name;
    private final int position;

    public CarState(String name, int position) {
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
