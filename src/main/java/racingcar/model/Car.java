package racingcar.model;

import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;

public class Car {
    protected static final int MOVABLE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;
    private static final RandomNumberGenerator DEFAULT_NUMBER_GENERATOR = new RandomNumberGenerator();

    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    protected Car(int position) {
        this.position = position;
    }

    public void move() {
        move(DEFAULT_NUMBER_GENERATOR);
    }

    public int getPosition() {
        return this.position;
    }

    /**
     * 숫자 생성기 값에 따라 이동하였다면 true, 이동하지 않았더라면 false를 리턴합니다.
     *
     * @param numberGenerator 숫자 생성기
     * @return 이동하였다면 true, 이동하지 않았더라면 false
     */
    protected boolean move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVABLE_NUMBER) {
            this.position++;
            return true;
        }

        return false;
    }
}
