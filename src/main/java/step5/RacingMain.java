package step5;

import step5.domain.Racing;
import step5.view.InputPrint;

public class RacingMain {
    public static void main(String[] args) {
        InputPrint print = new InputPrint();
        String[] carNames = InputPrint.getCarNames();
        int lapCount = InputPrint.getLapCount();
        print.inputs(carNames, lapCount);
        new Racing(carNames, lapCount);
    }
}
