package racingcar.view;

public class Output {
    private static final String CAR_DISTANCE_BAR = "-";
    private StringBuilder bar;

    public Output(final StringBuilder bar) {
        this.bar = bar;
    }

    public String mappingToBar(final int distance) {
        for (int i = 0; i < distance; i++) {
            bar.append(CAR_DISTANCE_BAR);
        }
        return bar.toString();
    }
}
