import racingcar.ui.InputView;

public class RacingCarApplication {
    private static InputView inputView;

    public static void main(String[] args) {
        inputView.askToInsertNumberOfCars();
        inputView.askToInsertNumberOfTries();
    }
}
