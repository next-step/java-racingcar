package step3;

public class GameRunner {
    public static void main(String[] args) {
        EnterGameConfig enterGameConfig = new EnterGameConfig();
        int carNumber = enterGameConfig.enterCarNumber();
        int iterate = enterGameConfig.enterIterate();

        Racing racing = new Racing(carNumber, iterate);
        racing.start();

        ResultPrinter resultView = new ResultPrinter(iterate);
        resultView.print(racing.getRacingRecordOfCars());
    }
}
