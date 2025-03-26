package racingcar.domain;

import racingcar.domain.dto.CarDto;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private int position;

    public Car() {
        position = INITIAL_POSITION;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public CarDto toDto() {
        return new CarDto(position);
    }

}
