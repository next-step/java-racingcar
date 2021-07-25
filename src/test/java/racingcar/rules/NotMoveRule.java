package racingcar.rules;

public class NotMoveRule implements Rule {
    @Override
    public boolean move() {
        return false;
    }
}
