import ui.InputView;
import ui.OutputView;

public class Main {
    public static void main(String[] args) {
        var grandPrix = InputView.makeGrandPrix();

        while (!grandPrix.isFinished()) {
            grandPrix.play();
            OutputView.printPosition(grandPrix);
        }
        System.out.println();
        OutputView.printChampion(grandPrix.report());
    }
}
