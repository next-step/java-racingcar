package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

import java.util.Objects;

public class RacingCar implements Cloneable {
    private int position;
    private String name;

    public RacingCar(String name) {
        validateCarName(name);
        this.name = name;
        this.position = 0;
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
    public RacingCar getSnapShot() {
        try {
            return (RacingCar) this.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private void validateCarName(String name) {
        if(isEmpty(name)) {
            throw new IllegalArgumentException("자동차 이름을 확인해 주세요");
        }
    }

    private boolean isEmpty(String str) {
        return (Objects.isNull(str) || str.equals(""));
    }
}

