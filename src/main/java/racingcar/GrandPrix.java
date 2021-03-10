package racingcar;

import java.util.ArrayList;
import java.util.List;

// 서비스 로직,
public class GrandPrix {
    private ResultView resultView = new ResultView();

    public void grandPrixStart(int inputPlayerCount, int inputLastLab) {
        List<FormulaOne> formulaOnes = createFomualOne(inputPlayerCount, inputLastLab);

        liveRacing(formulaOnes);
    }

    public List<FormulaOne> createFomualOne(int inputPlayerCount, int inputLastLab) {
        List<FormulaOne> formulaOnes = new ArrayList<>();

        for(int i = 0; i < inputPlayerCount; i++) {
            formulaOnes.add(new FormulaOne(inputLastLab));
        }

        return formulaOnes;
    }

    public void liveRacing(List<FormulaOne> formulaOnes) {
        while(true) {
            if (nextTurn(formulaOnes)) {
                break;
            }
            resultView.printOneLine();
        }
    }

    public boolean nextTurn(List<FormulaOne> formulaOnes) {
        boolean raceEnd = false;

        for (FormulaOne formulaOne : formulaOnes) {
            formulaOne.formulaOneMove();

            resultView.printLab(formulaOne.getLab());
            if (formulaOne.getLab() >= formulaOne.getLastLab()) {
                raceEnd = true;
            }
        }

        return raceEnd;
    }
}
