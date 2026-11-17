package racingcar.view;

public class PositionFormatter {
    private static final String POSITION_SIGN = "-";

    public String format(int position) {
        return POSITION_SIGN.repeat(position);
    }
}
