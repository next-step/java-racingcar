package racingcar.domain;

public class AlwaysMoveCarMover implements CarMover {

    @Override
    public boolean movable() {
        return true;
    }
}
