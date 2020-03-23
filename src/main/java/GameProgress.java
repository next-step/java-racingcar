import java.util.Random;

public class GameProgress {

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;

    public void progress(RacingGame game) {

        OutputView output = new OutputView();
        for (int i = 0; i < game.getTime(); i++) {
            move(game);
            output.resultView(game);
            System.out.println("");
        }
    }

    public int[] move(RacingGame game) {
        Random random = new Random();

        for (int i = 0; i < game.getCarPosition().length; i++) {
            int ranCount = random.nextInt(RANDOM_BOUND);
            game.getCarPosition()[i] = (ranCount >= BASE_POINT) ? game.getCarPosition()[i] + DISTANCE : game.getCarPosition()[i];
        }

        return game.getCarPosition();
    }
}
