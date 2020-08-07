import racingcar.domain.Engine;
import racingcar.domain.RacingData;
import racingcar.domain.RacingGame;
import racingcar.ui.InputAvailable;
import racingcar.ui.InputView;
import racingcar.ui.ScannerInput;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView(scannerInput());

        RacingGame racingGame = new RacingGame(RacingData.of(inputView), new Engine());
        racingGame.run();
        racingGame.result();
    }

    private static InputAvailable scannerInput() {
        return new InputAvailable() {
            @Override
            public String inputNames() {
                return ScannerInput.nextLine();
            }

            @Override
            public int inputNumberOfCars() {
                return ScannerInput.nextInt();
            }

            @Override
            public int inputTryCount() {
                return ScannerInput.nextInt();
            }
        };
    }
}
