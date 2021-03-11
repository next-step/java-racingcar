package racingcar;

public class MoveStopStrategy implements MoveStrategy {

    public static final MoveStopStrategy INSTANCE = new MoveStopStrategy();

    private void MoveStopStrategy() {

    }

    @Override
    public boolean move(FormulaOne formulaOne) {
        return false;
    }
}
