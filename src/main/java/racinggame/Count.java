package racinggame;

import racinggame.util.Validator;

public class Count {

    private final int count;

    public Count(int count) {
        if (!Validator.isPositiveNumber(count)) {
            throw new IllegalArgumentException("시도할 회수는 0보다 큰 숫자여야 합니다.");
        }
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
