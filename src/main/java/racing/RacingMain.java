package racing;

public class RacingMain {

    public static void main(String[] args) {

        int times = RacingInputView.inputTryNo("시도할 회수는 몇 회 인가요?");
        int cars = RacingInputView.inputTryNo("자동차 대수는 몇 대 인가요?");

        RacingGame racingGame = new RacingGame(times, cars);

        while (!racingGame.isFinish()) {
            racingGame.move();
            RacingResultView.render(racingGame.getCarsPositions());
        }
    }
}
