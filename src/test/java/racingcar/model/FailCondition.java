package racingcar.model;

public class FailCondition implements Condition {

    @Override
    public boolean inspect() {
        return false;
    }
}
