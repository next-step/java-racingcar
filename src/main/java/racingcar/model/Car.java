package racingcar.model;

import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Car {
    protected static final int MOVABLE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;
    private static final NumberGenerator DEFAULT_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final int INCREASE_POSITION_COUNT = 1;

    private AtomicInteger position;
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new AtomicInteger(DEFAULT_POSITION);
    }

    protected Car(String name, int position) {
        this.name = new Name(name);
        this.position = new AtomicInteger(position);
    }

    public void move() {
        move(DEFAULT_NUMBER_GENERATOR);
    }

    /**
     * 숫자 생성기 값에 따라 이동하였다면 true, 이동하지 않았더라면 false를 리턴합니다.
     *
     * @param numberGenerator 숫자 생성기
     * @return 이동하였다면 true, 이동하지 않았더라면 false
     */
    protected boolean move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVABLE_NUMBER) {
            increasePosition();
            return true;
        }

        return false;
    }

    public String getStatus() {
        return String.format("%s : %s", this.name, getPositionBar(this.position));
    }

    private void increasePosition() {
        this.position = new AtomicInteger(
                this.position.intValue() + INCREASE_POSITION_COUNT
        );
    }

    private String getPositionBar(AtomicInteger position) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, position.intValue())
                .forEach(action -> stringBuilder.append("-"));

        return stringBuilder.toString();
    }
}
