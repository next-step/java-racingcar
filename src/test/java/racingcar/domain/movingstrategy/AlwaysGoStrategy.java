package racingcar.domain.movingstrategy;

public class AlwaysGoStrategy implements MovingStrategy {

    @Override
    public boolean movable() {
        return true;
    }

}
