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
        this.validate();
    }

    public void accelerate() {
        if (accelerateResolver.resolve()) {
            lap++;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void validate() {
        if (driverName == null || driverName.length() <= 0) {
            throw new IllegalArgumentException("이름은 반드시 필요합니다.");
        }
        if (driverName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과 할 수 없습니다.");
        }
    }
}
