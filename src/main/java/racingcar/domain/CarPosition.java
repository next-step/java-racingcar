package racingcar.domain;

import java.util.Objects;

public class CarPosition{
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public void addOne() {
        this.position++;
    }

    public boolean isMoreThan(CarPosition tempWinnerPosition) {
        return tempWinnerPosition.position<=this.position;
    }

    public CarPosition comparePosition(CarPosition comparePosition){
        if(this.position <= comparePosition.position){
            return comparePosition;
        }
        return this;
    }

    public int getPosition(){
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
