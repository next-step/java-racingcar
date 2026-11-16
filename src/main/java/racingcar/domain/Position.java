package racingcar.domain;

public class Position {

    public static final int DEFAULT_INIT_POSITION = 0;
    private final int position;

    public Position() {
        this(DEFAULT_INIT_POSITION);
    }

    public Position(int position) {
        if (position < 0) {
            throw new RuntimeException("음수 위치에 존재 할 수 없습니다.");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }


    public int getPosition() {
        return position;
    }
}


