package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

import java.util.Random;

public class RacingCar {

    private static final Random RANDOM = new Random();
    private int position;
    private ForwardingRule forwardingRule;

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
