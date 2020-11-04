package racingcar.domain.car;

import racingcar.domain.exception.InvalidCarNameLengthException;
import racingcar.dto.RecordDto;

public class Car {
    private final String name;
    private Integer position;

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car ofName(String name) {
        validateName(name);
        return new Car(name, 0);
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new InvalidCarNameLengthException();
        }
    }

    public void move() {
        position += 1;
    }

    public Integer getPosition() {
        return position;
    }

    public RecordDto getRecord() {
        return new RecordDto(name, position);
    }

    public boolean isAt(Integer position) {
        return this.position.equals(position);
    }
}
