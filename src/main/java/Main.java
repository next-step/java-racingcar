public class Main {
    public static void main(String[] args) {
        final int carNum = InputView.inputCarNum();
        final int tryNum = InputView.inputTryNum();

        final RacingManager racingManager = new RacingManager(carNum, tryNum);

        racingManager.play();

        ResultView.printTitle();
        ResultView.printResult(racingManager.getCarsSnapShots());
    }
}
