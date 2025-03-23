import java.util.List;

public class GameController {
    public void play() {
        List<String> carNames = InputView.getCarName();
        int tryCount = InputView.getTryCount();
        InputView.closeScanner();

        Racing racing = new Racing(carNames);

        for (int i = 0; i < tryCount; i++) {
            racing.start();
        }

    }
}
