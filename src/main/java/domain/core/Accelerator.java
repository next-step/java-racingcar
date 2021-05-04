package domain.core;

import static domain.core.GameOptions.MIN_POWER;

/**
 * 전진 할 수 있는 Power 원시값 포장
 */
public class Accelerator {
    private final int power;

    public Accelerator(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public boolean isDriving() {
        return power >= MIN_POWER;
    }
}
