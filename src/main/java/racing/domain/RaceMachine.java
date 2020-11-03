package racing.domain;

import lombok.Getter;
import utils.RandomUtils;

@Getter
public class RaceMachine {
    private final int id;
    private int horsePower = 0;
    private int lap = 0;

    public RaceMachine(int id) {
        this.id = id;
    }

    public void accelerate() {
        horsePower = RandomUtils.nextInt(10);
        if (horsePower >= 4) {
            lap++;
        }
    }
}
