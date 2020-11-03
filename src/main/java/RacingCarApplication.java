import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingCarApplication {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        inputView.askToInsertNumberOfCars();
        inputView.askToInsertNumberOfTries();
        resultView.print();
    }
}
