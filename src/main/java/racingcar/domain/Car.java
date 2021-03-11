package racingcar.domain;

import racingcar.util.Conditions;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private Name name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

   public Name getName() {
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

    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining(""));
    }
}
