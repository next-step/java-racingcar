package step3.domain;

import step3.domain.strategy.MoveStrategy;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-04.
 * 자동차 객체
 */
public class Car {

    private final String name;
    private int step; //자동차가 전진한 횟수
    private final int MAXIMUM_CAR_NAME_LENGTH = 5;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int step) {
        checkEmpty(name);
        checkLength(name, MAXIMUM_CAR_NAME_LENGTH);

        this.name = name;
        this.step = step;
    }


    public void forward(int step) {
        this.step = this.step + step;
    }

    public int getStep() {
        return this.step;
    }

    public String getName() {
        return name;
    }

    public void forward(MoveStrategy moveStrategy) {
        this.step = this.step + moveStrategy.move();
    }

    private static void checkEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()
                || "".equals(input) || " ".equals(input)) {
            throw new IllegalArgumentException("경주할 차 이름의 입력값이 없습니다.");
        }
    }

    private static void checkLength(String input, int length) {
        if (input.length() > length) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 %s 자를 초과할 수 없습니다.", length));
        }
    }
}
