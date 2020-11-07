package racing.domain;

import lombok.Getter;
import racing.resolver.AccelerateResolver;

@Getter
public class RaceMachine {
    private int id;
    private final String driverName;
    private int lap = 1;
    private final AccelerateResolver accelerateResolver;

    public RaceMachine(String driverName, AccelerateResolver accelerateResolver) {
        this.driverName = driverName;
        this.accelerateResolver = accelerateResolver;
    }

    public void accelerate() {
        if (accelerateResolver.resolve()) {
            lap++;
        }
    }

    public void setId(int id) {
        this.id = id;
    }
}
