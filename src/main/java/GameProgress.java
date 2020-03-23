import java.util.Random;

public class GameProgress {

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;
    private final int ZERO = 0;

    public void progress(RacingGame racingGame) {

        OutputView output = new OutputView();
        for (int i = 0; i < racingGame.getTime(); i++) {
            move(racingGame);
            output.resultView(racingGame);
            System.out.println("");
        }
    }

    public int[] move(RacingGame racingGame) {
        Random random = new Random();

        for (int i = 0; i < racingGame.getCarPosition().length; i++) {
            int ranCount = random.nextInt(RANDOM_BOUND);
            racingGame.getCarPosition()[i] += (ranCount >= BASE_POINT) ? DISTANCE : ZERO;
        }

        return racingGame.getCarPosition();
    }
}
