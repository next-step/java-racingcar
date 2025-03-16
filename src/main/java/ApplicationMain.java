public class ApplicationMain {
    public static void main(String[] args) {

        int carNum = InputView.getCarNum();
        int tryCount = InputView.getTryCount();
        InputView.closeScanner();

        Racing racing = new Racing(carNum, tryCount);

        racing.start();

        ResultView.printRace(racing);

    }

}
