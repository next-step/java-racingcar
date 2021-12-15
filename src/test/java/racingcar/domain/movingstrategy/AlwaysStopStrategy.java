package racingcar.domain.movingstrategy;

public class AlwaysStopStrategy implements MovingStrategy {

    @Override
    public boolean movable() {
        return false;
    }

}
