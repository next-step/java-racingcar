package racingcar.view;

public class Output {
    private static final String CAR_DISTANCE_BAR = "-";
    private StringBuilder bar;

    public Output() {
        this(new StringBuilder());
    }

    public Output(final StringBuilder bar) {
        this.bar = bar;
    }

    public void mappingToBar(final int distance) {
        for (int i = 0; i < distance; i++) {
            bar.append(CAR_DISTANCE_BAR);
        }
    }

    public String getBar() {
        return bar.toString();
    }
}
