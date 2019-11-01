package winner.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 21:39
 */
public class CarPosition {

    private static final String POSITION_VIEW_TEXT = "-";
    private int position;

    public CarPosition() {
        this(0);
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public void move() {
        position++;
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
