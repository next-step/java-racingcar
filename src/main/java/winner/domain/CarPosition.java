package winner.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 21:39
 */
public class CarPosition {

    private static final String POSITION_VIEW_TEXT = "-";
    private static final int INIT_CAR_POSITION = 0;
    private static final int INCREASE = 1;

    private final int position;

    public CarPosition() {
        this(INIT_CAR_POSITION);
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition move() {
        return new CarPosition(this.position + INCREASE);
    }

    public String toText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_VIEW_TEXT);
        }
        return stringBuilder.toString();
    }

    public boolean isMax(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getCurrentPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
