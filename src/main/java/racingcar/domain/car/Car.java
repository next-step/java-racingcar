package racingcar.domain.car;

import racingcar.domain.random.RandomStrategy;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름이 5자를 초과합니다.";
    private static final int INITIAL_POSITION = 0;
    private static final int THRESHOLD_TO_MOVE = 4;
    private static final int MOVE_ONE_STEP = 1;
    private static final int MAXIMUM_ALLOWED_NAME_LENGTH = 5;

    private final String name;
    public int position;

    private Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    private static void validateCarName(String name) {
        if (name.length() > MAXIMUM_ALLOWED_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void go(RandomStrategy randomStrategy) {
        if (randomStrategy.get() > THRESHOLD_TO_MOVE) {
            this.position += MOVE_ONE_STEP;
        }
    }

    public boolean comparePosition(Car o) {
        return position == o.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
