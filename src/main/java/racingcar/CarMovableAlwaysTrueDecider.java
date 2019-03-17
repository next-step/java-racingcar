package racingcar;

public class CarMovableAlwaysTrueDecider implements CarMovableDecider {
    @Override
    public boolean movable() {
        return true;
    }
}
