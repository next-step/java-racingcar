package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GrandPrix {

    public void grandPrixStart(int inputPlayerCount, int inputLastLab) {
        ResultView resultView = new ResultView();

        List<FormulaOne> formulaOnes = createFomualOne(inputPlayerCount, inputLastLab);

        resultView.liveRacing(formulaOnes);
    }

    public List<FormulaOne> createFomualOne(int inputPlayerCount, int inputLastLab) {
        List<FormulaOne> formulaOnes = new ArrayList<>();
        for(int i = 0; i < inputPlayerCount; i++) {
            formulaOnes.add(new FormulaOne(inputLastLab));
        }

        return formulaOnes;
    }
}
