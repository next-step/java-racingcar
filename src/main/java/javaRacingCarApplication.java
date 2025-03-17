public final class javaRacingCarApplication {

    private javaRacingCarApplication() {}

    public static void main(String[] args) {
        final int carNum = InputView.inputCarNum();
        final int tryNum = InputView.inputTryNum();
        final RacingManger racingManger = new RacingManger(carNum);
        ResultView.printTitle();
        for (int i = 0; i < tryNum; i++) {
            racingManger.play();
            ResultView.printResult(racingManger.getCars());
        }
    }
}
