package racinggame.domain;

import racinggame.random.RandomNumberGenerator;

import static racinggame.domain.RacingGameRules.MAX_RACING_CAR_NAME_LENGTH;

public class RacingCar {
    public static final int MOVE_THRESHOLD = 4;

    private final RandomNumberGenerator generator;
    private final String name;
    private int position;

    public RacingCar(final RandomNumberGenerator generator, final String name) {
        if (name.length() > MAX_RACING_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 최대 " + MAX_RACING_CAR_NAME_LENGTH + "글자를 초과 할 수 없습니다.");
        }

        this.generator = generator;
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (generator.generate() > MOVE_THRESHOLD) {
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }

    public String name() {
        return name;
    }
}
