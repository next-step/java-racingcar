package racingcar;

public class CarMovableAlwaysFalseDecider implements CarMovableDecider {
    @Override
    public boolean movable() {
        return false;
    }
}
