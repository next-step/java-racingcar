package study.racingCar;

import java.util.Objects;

public class Position {

    private int currentPosition;

    public Position() {
        this(0);
    }

    public Position(int num){
        if (num < 0){
            throw new IllegalArgumentException();
        }
        this.currentPosition = num;
    }

    int position(){
        return currentPosition;
    }

    Position increase(int num) {
        if (num > 3){
            return new Position(this.currentPosition+1);
        }
        return new Position();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return currentPosition == position.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition);
    }
}
