package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;
import camp.nextstep.edu.nextstep8.racing.rule.RandomForwardingRule;

public class RacingCar {
    private int position;
    private ForwardingRule forwardingRule;

    public RacingCar() {
        this(new RandomForwardingRule());
    }

    public RacingCar(ForwardingRule forwardingRule) {
        this.forwardingRule = forwardingRule;
    }

    public void move() {
        if (forwardingRule.canFoward()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
