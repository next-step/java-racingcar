package racingcar.domain.strategy;

public class FixedMoving {

    private FixedMoving() {

    }

    public static final MovingStrategy alwaysGo = () -> true;
    public static final MovingStrategy alwaysStop = () -> false;

}
