package racingcar;

public class MoveOneStrategy implements MoveStrategy {
    public static final MoveOneStrategy INSTANCE = new MoveOneStrategy();

    public static final int MOVE_TWO = 1;

    private void MoveOneStrategy() {

    }

    @Override
    public boolean move(FormulaOne formulaOne) {
        Circuit circuit = formulaOne.getCircuit();
        circuit.addLabCount(MOVE_TWO);
        return true;
    }
}
