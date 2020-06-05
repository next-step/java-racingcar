package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

public class RacingCar {
    private int position;
    private String name;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = validateEmptyElseGet(name);
        this.position = position;
    }

    public void move(ForwardingRule forwardingRule) {
        if (forwardingRule.canForward()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private String validateEmptyElseGet(String name) {
        if(null == name || name.equals("")) {
            throw new IllegalArgumentException("자동차 이름을 확인해 주세요");
        }
        return name;
    }
}

