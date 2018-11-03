package racing;

public class RacingMain {

    private RacingInputView racingInputView = null;
    private RacingGame racingGame = null;
    private RacingResultView racingResultView = null;

    public RacingMain() {
        racingInputView = new RacingInputView();
        racingResultView = new RacingResultView();
    }

    public void run() {
        racingInputView.render();

        if (!racingInputView.isDone()) {
            System.err.println("레이신 게임을 하기 위한 값이 모두 입력되지 않았습니다. 게임을 다시 시작해 주세요.");
        }

        racingGame = new RacingGame(racingInputView.getTimes(), racingInputView.getCars());

        while (!racingGame.isFinish()) {
            racingResultView.render(racingGame.move());
        }

    }

    public static void main(String[] args) {

        RacingMain main = new RacingMain();
        main.run();

    }
}
