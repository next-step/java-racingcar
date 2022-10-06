package racingcar.domain;

public class FailCondition implements Condition {

    @Override
    public boolean inspect() {
        return false;
    }
}
