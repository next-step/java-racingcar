package study.racingcar.model;

import java.util.Objects;

public class Position {
    private static final String MOVE_CHARACTER = "-";
    private static final int START_LOCATION = 0;
    private static final int MOVE_NUMBER = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move(){
        this.position += MOVE_NUMBER;
    }

    public String getLocation(){
        String location = "";
        for(int i = START_LOCATION; i < position; i++){
            location += MOVE_CHARACTER;
        }
        return location;
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
