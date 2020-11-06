package racing.domain;

import lombok.Getter;
import racing.resolver.AccelerateResolver;

@Getter
public class RaceMachine {
    private final int id;
    private int lap = 1;
    private final AccelerateResolver accelerateResolver;

    public RaceMachine(int id, AccelerateResolver accelerateResolver) {
        this.id = id;
        this.accelerateResolver = accelerateResolver;
    }

    public void accelerate() {
        if (accelerateResolver.resolve()) {
            lap++;
        }
    }
}
