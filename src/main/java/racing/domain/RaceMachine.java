package racing.domain;

import lombok.Getter;
import utils.RandomUtils;

@Getter
public class RaceMachine {
    private Integer horsePower;
    private Integer lap = 0;

    public void accelerate() {
        horsePower = RandomUtils.nextInt(10);
        if (horsePower >= 4) {
            lap++;
        }
    }
}
