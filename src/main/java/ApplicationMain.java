import java.util.List;
public class ApplicationMain {
    public static void main(String[] args) {

        List<String> carNames = InputView.getCarName();
        int tryCount = InputView.getTryCount();
        InputView.closeScanner();

        Racing racing = new Racing(carNames, tryCount);

        racing.start();

    }

}
