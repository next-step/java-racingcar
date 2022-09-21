package step3.domain;

import step3.exception.NegativePositionException;

public class Position {
    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validation(position);
        this.position = position;
    }

    private void validation(int state) {
        if (state < 0) {
            throw new NegativePositionException("음수의 전진 상태는 존재하지 않습니다.");
        }
    }

    public Position advance() {
        return new Position(position + 1);
    }

    public int value() {
        return position;
    }
}
