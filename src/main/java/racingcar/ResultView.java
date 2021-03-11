package racingcar;

import java.util.List;

public class ResultView {

    public void printGrandPrixRecords(List<FormulaOne> formulaOnes) {
        formulaOnes.stream()
                .forEach(fo -> printLab(fo.getCircuit()));

        System.out.println("");
    }

    public void printLab(Circuit circuit) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < circuit.getLabCount(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }
}
