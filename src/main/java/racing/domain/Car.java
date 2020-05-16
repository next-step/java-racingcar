package racing.domain;

import racing.utils.EmptyCheckUtil;

import java.util.Objects;

public class Car {
    private int position = 0;
    private String name;

    public Car(String name) {
        this.validationName(name);
        this.name = name;
    }

    private void validationName(String name) {
        EmptyCheckUtil.emptyCheck(name);
    }

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

    public String getName() {
        return this.name;
    }
}
