package racingcar;

import java.util.List;

public class ResultView {

    public void liveRacing(List<FormulaOne> formulaOnes) {

        while(true) {
            if (nextTurn(formulaOnes)) {
                break;
            }
            printOneLine();
        }
    }

    public boolean nextTurn(List<FormulaOne> formulaOnes) {
        boolean raceEnd = false;

        for (FormulaOne formulaOne : formulaOnes) {
            formulaOne.formulaOneMove();
            printLab(formulaOne.getLab());
            if (formulaOne.getLab() >= formulaOne.getLastLab()) {
                raceEnd = true;
            }
        }

        return raceEnd;
    }

    public void printLab(int labCount) {
        for (int i = 0; i < labCount; i++) {
            System.out.print("-");
        }
        printOneLine();
    }

    private void printOneLine() {
        System.out.println("");
    }
}
