package racingcar.view;

public class LaneViewModel {
    private final String name;
    private final int position;

    public LaneViewModel(String name, int position) {
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
