package step4;

class RacingGameWinnerApplication {

    public static void main(String[] args) {
        InputView input = new InputView();
        ResultView result = new ResultView();
        RacingGameWinner racingGameWinner = new RacingGameWinner();

        String[] carName = input.inputCarName();
        int carNumber = carName.length;
        int tryCount = input.inputTryCount();

        racingGameWinner.setInitPosition(carNumber);

        System.out.println("실행결과");

        while (tryCount-- > 0) {
            racingGameWinner.startRacing(carNumber);
            result.racingView(racingGameWinner.carPositions, carName);
        }
        result.findMaxScoreWinner(racingGameWinner.carPositions, carName);
    }
}
