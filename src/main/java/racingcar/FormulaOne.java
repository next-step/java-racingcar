package racingcar;

public class FormulaOne {
    private static final int MOVE_ONE_CONDITION = 4;    // 기본 랩 진행 조건
    private static final int MOVE_TWO_CONDITION = 9;    // 추가 랩 진행 조건

    private MoveStrategy moveStrategy;
    private Circuit circuit;

    public FormulaOne(int lastLab) {
        this.circuit = new Circuit(lastLab);
    }

    public Circuit getCircuit() {
        return this.circuit;
    }

    // 인터페이스 방식으로 변경
    public boolean move(int randomValue) {
        setMoveStrategy(moveStrategyType(randomValue));
        return moveStrategy.move(this);
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public MoveStrategy moveStrategyType(int randomValue) {
        int moveCondition = MOVE_ONE_CONDITION + circuit.getPitstopPenalty();

        if (MOVE_TWO_CONDITION <= randomValue) {
            return MoveTwoStrategy.INSTANCE;
        }

        if (moveCondition <= randomValue) {
            return MoveOneStrategy.INSTANCE;
        }

        return MoveStopStrategy.INSTANCE;
    }

}
