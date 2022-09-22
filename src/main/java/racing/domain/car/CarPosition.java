package racing.domain.car;

import racing.exception.NegativePositionException;

public class CarPosition {

    private final int position;

    public CarPosition() {
        this(0);
    }

    public CarPosition(int position) {
        validation(position);
        this.position = position;
    }

    private void validation(int state) {
        if (state < 0) {
            throw new NegativePositionException("음수의 전진 상태는 존재하지 않습니다.");
        }
    }

    public CarPosition advance() {
        return new CarPosition(position + 1);
    }

    public int value() {
        return position;
    }
}
