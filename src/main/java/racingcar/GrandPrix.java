package racingcar;

import java.util.ArrayList;
import java.util.List;

// 서비스 로직
public class GrandPrix {
    ResultView resultView = new ResultView();

    public void start(int inputPlayerCount, int inputLastLab) {
        List<FormulaOne> formulaOnes = createFomualOne(inputPlayerCount, inputLastLab);

        System.out.println("실행결과");

        while(!isFinish(formulaOnes)) {
            nextTurn(formulaOnes);
            resultView.printGrandPrixRecords(formulaOnes);
        }
    }

    public List<FormulaOne> createFomualOne(int inputPlayerCount, int inputLastLab) {
        List<FormulaOne> formulaOnes = new ArrayList<>();

        for(int i = 0; i < inputPlayerCount; i++) {
            formulaOnes.add(new FormulaOne(inputLastLab));
        }

        return formulaOnes;
    }

    public boolean isFinish(List<FormulaOne> formulaOnes) {
        return formulaOnes.stream()
                .anyMatch(f -> f.getCircuit().finish());
    }

    public void nextTurn(List<FormulaOne> formulaOnes) {
        formulaOnes.stream()
                .forEach(fo -> fo.move(RandomDice.getRandomValue()));
    }
}
