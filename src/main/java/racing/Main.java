package racing;

public class Main {
    public static void main(String[] args) {

        InputView carCountQuestion = InputView.addQuestion("자동차 대수는 몇 대 인가요?");
        int carCount = carCountQuestion.input();
        InputView roundQuestion = InputView.addQuestion("시도할 회수는 몇 회 인가요?");
        int round = roundQuestion.input();

        RacingGame racingGame = new RacingGame(carCount, round);
        RacingGameResult gameResult = racingGame.playGame();

        ResultView resultView = new ResultView("실행 결과");
        resultView.print(gameResult.getAllRoundCarsPosition());
    }
}
