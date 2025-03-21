package racing.model;

import java.util.Objects;

public class CarPosition {

    private Integer position;

    public CarPosition(Integer position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void progress() {
        position++;
    }

    public int max(int position) {
        return Math.max(position, this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
