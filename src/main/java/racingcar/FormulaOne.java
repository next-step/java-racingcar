package racingcar;

public class FormulaOne {
    private static final int LAB_PLUS_ONE_CONDITION = 4;    // 기본 랩 진행 조건
    private static final int LAB_PLUS_TWO_CONDITION = 9;    // 추가 랩 진행 조건

    private int labCount;       // 현재 진행 랩
    private int lastLab;        // 목표 랩
    private boolean pitstop;    // 타이어교체 피트스톱 여부

    public FormulaOne(int lastLab) {
        this.lastLab = lastLab;
        this.labCount = 0;
        this.pitstop = false;
    }

    public int getLab() {
        return labCount;
    }

    public int getLastLab() {
        return lastLab;
    }

    public boolean getPitstop() {
        return this.pitstop;
    }

    public void formualOnePitstop(){
        if ((8 <= RandomDice.getRandomValue()) && !(this.lastLab == this.labCount)) {
            changePitstop();
        }
    }

    // 테스트용도
    public void racingCarPitstopTest(int pitstopRandomValue){
        if ((8 <= pitstopRandomValue) && !(this.lastLab == this.labCount)) {
            changePitstop();
        }
    }

    public void formulaOneMove() {
        int labCondition = LAB_PLUS_ONE_CONDITION + getPitstopPenalty();
        int randomValue = RandomDice.getRandomValue();

        if (labCondition <= randomValue) {
            formualOnePitstop();
            ++this.labCount;
        }

        if (LAB_PLUS_TWO_CONDITION <= randomValue
                && this.labCount < this.lastLab) {
            ++this.labCount;
        }
    }

    // 테스트용도
    public void formulaOneMoveTest(int randomValue) {
        int labCondition = LAB_PLUS_ONE_CONDITION + getPitstopPenalty();

        if (labCondition <= randomValue) {
            ++this.labCount;
        }

        if (LAB_PLUS_TWO_CONDITION <= randomValue) {
            ++this.labCount;
        }
    }

    public int getPitstopPenalty() {
        int result = 0;
        if (this.pitstop) {
            changePitstop();
            ++result;
        }
        return result;
    }

    public void changePitstop() {
        this.pitstop = !this.pitstop;
    }
}
