public class ApplicationMain {
    public static void main(String[] args) {

        String[] carName = InputView.getCarName();
        int tryCount = InputView.getTryCount();
        InputView.closeScanner();

        Racing racing = new Racing(carName, tryCount);

        racing.start();

    }

}
