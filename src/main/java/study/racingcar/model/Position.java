package study.racingcar.model;

import java.util.Objects;

public class Position {
    private static final int MOVE_NUMBER = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move(){
        this.position += MOVE_NUMBER;
    }

    public int getLocation(){
        return position;
    }

    public int getMaxPosition(int maxPosition) {
        if (maxPosition < position){
            return position;
        }
        return maxPosition;
    }

    public boolean isWinnerPosition(int maxPosition) {
        if (maxPosition == position){
            return true;
        }
        return  false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
