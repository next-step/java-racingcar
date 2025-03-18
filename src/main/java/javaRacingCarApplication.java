public final class javaRacingCarApplication {

    private javaRacingCarApplication() {}

    public static void main(String[] args) {
        final String carString = InputView.inputCarString();
        final int tryNum = InputView.inputTryNum();
        final RacingManger racingManger = new RacingManger(carString);
        ResultView.printTitle();
        for (int i = 0; i < tryNum; i++) {
            racingManger.play();
            ResultView.printResult(racingManger.getCars());
        }
        ResultView.printWinners(racingManger.getWinners());
    }
}
