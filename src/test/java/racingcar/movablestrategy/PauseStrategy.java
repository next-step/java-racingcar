package racingcar.movablestrategy;

public class PauseStrategy implements MovableStrategy{
    @Override
    public boolean movable() {
        return false;
    }
}
