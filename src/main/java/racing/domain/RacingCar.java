package racing.domain;

import racing.dto.RacingCarStatus;
import racing.util.DefaultRandomNumberProvider;
import racing.util.RandomNumberProvider;

public class RacingCar {
    public static final int MOVE_BOUND_VALUE = 4;
    static RandomNumberProvider RANDOM_PROVIDER = new DefaultRandomNumberProvider();

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public RacingCarStatus rush() {
        if (RANDOM_PROVIDER.getRandomNumber() >= MOVE_BOUND_VALUE) {
            position += 1;
        }

        return new RacingCarStatus(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    // 테스트를 위한 목적으로만 사용함
    void setPosition(int position) {
        this.position = position;
    }
}
