package racing;

public class Main {
    public static void main(String[] args) {

        InputView carCountQuestion = InputView.addQuestion("자동차 대수는 몇 대 인가요?");
        InputView roundQuestion = InputView.addQuestion("시도할 회수는 몇 회 인가요?");

        RacingGame racingGame = new RacingGame(carCountQuestion.input(), roundQuestion.input());

        racingGame.playGame();
    }
}
