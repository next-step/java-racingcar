package racing.domain;

import java.util.Objects;

public class Car {
    private int position = 0;

    public void move(CarMovement carMovement) {
        this.validateCarMovement(carMovement);

        if (carMovement.isMove()) {
            this.position++;
        }
    }

    private void validateCarMovement(CarMovement carMovement) {
        if (Objects.isNull(carMovement)) {
            throw new IllegalArgumentException();
        }
    }

    public int findCurrentPosition() {
        return this.position;
    }
}
