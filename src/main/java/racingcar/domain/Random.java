package racingcar.domain;

public class Random implements MoveStrategy{

    private static final int MAX_NUMBER = 9;

    @Override
    public int availMoveValue() {
        return (int) (Math.random() * MAX_NUMBER);
    }
}
