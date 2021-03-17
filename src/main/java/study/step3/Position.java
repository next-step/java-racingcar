package study.step3;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;
    private int position;

    public Position(){
        this.position = START_POSITION;
    }

    public Position(int position) {
        if(position < 0){
            throw new IllegalArgumentException("포지션은 0이상의 값을 가질 수 있습니다.");
        }
        this.position = position;
    }

    public void move() {
        position = position + 1;
    }

    public int getPosition() {
        return position;
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
