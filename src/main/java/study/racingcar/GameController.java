package study.racingcar;

public class GameController {
    /**
     * 게임 실행을 담당한다
     */
    public static void main(String[] args) {
        final int numOfCar = getRoundsToPlay();
        final int rounds = getTotalNumberOfCar();
        RacingCarGame racingCarGame = new RacingCarGame(numOfCar, rounds);
        racingCarGame.run();
    }

    private static int getRoundsToPlay() {
        OutputView.printTryCountSign();
        return InputView.getTryCount();
    }

    private static int getTotalNumberOfCar() {
        OutputView.printCarNumberSign();
        return InputView.getCarNumber();
    }
}
