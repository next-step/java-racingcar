package study.racing.domain;

import java.util.Objects;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public int value() {
        return this.position;
    }

    public void increasePosition(){
        this.position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int max(int maxPosition){
        return Math.max(maxPosition, this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
