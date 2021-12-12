package racingcar.domain.movingstrategy;

public class AlwayStopStrategy implements MovingStrategy {

    @Override
    public boolean movable() {
        return false;
    }

}
