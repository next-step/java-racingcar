package racingcar;

public class MoveTwoStrategy implements MoveStrategy {
    public static final MoveTwoStrategy INSTANCE = new MoveTwoStrategy();
    public static final int MOVE_TWO = 2;


    private void MoveTwoStrategy() {

    }

    @Override
    public boolean move(FormulaOne formulaOne) {
        Circuit circuit = formulaOne.getCircuit();
        circuit.addLabCount(MOVE_TWO);
        return true;
    }
}
