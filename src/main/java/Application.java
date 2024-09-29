import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarInputView racingCarInputView = new RacingCarInputView();

        int carCount = racingCarInputView.getCarCount();
        int attempts = racingCarInputView.getAttempts();

        RacingGame racingGame = new RacingGame(carCount,attempts,new RandomMovementCondition());
        List<List<Integer>> allStates = racingGame.run();

        RacingCarOutputView racingCarOutputView = new RacingCarOutputView();

        racingCarOutputView.printGame(allStates);
    }
}
