package step3;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = InputView.create();

        RacingGameManager racingGameManager = RacingGameManager
                .start(inputView.getRacingCarCount(), inputView.getGameRound());

        while (racingGameManager.hasNextRound()) {
            racingGameManager.nextRound();
            ResultView.printPosition(racingGameManager.getCarPosition());
        }
    }
}
