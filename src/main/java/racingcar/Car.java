package racingcar;

import java.util.Random;

public class Car {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_BOUND = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private int position;
    private String name;

    private Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public static Car of(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        return new Car(0, name);
    }


    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public void move(Random random) {
        if (this.isMove(random)) {
            this.position++;
        }
    }

    private boolean isMove(Random random) {
        return this.getRandomNumber(random) >= Car.MOVE_BOUND;
    }

    private int getRandomNumber(Random random) {
        return random.nextInt(Car.RANDOM_NUMBER_BOUND);
    }
}
