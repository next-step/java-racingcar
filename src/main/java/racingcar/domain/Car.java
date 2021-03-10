package racingcar.domain;

import racingcar.util.Conditions;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void updatePositionByCondition(int number) {
        positionValueValidation(number);

        if (Conditions.isAcceptCondition(number)) {
            position++;
        }
    }

    public void positionValueValidation (int number) {
        if (Conditions.isInvalidNumber(number)) {
            throw new IllegalArgumentException("0 ~ 9까지의 값만 사용할 수 있습니다.");
        }
    }

    public boolean nameValueInValidation() {
        return Conditions.isInValidName(name);
    }

    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining(""));
    }
}
