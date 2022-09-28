package racingcar;

public class BadCondition implements Condition {

    @Override
    public boolean inspect() {
        return false;
    }
}
