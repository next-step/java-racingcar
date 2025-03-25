package controller;

import ui.InputView;
import ui.OutputView;

public class GrandPrixController {

    public static void run() {
        var grandPrix = InputView.makeGrandPrix();

        while (!grandPrix.isFinished()) {
            grandPrix.play();
            OutputView.printPosition(grandPrix.report());
        }
        OutputView.printChampion(grandPrix.report());
    }
}
