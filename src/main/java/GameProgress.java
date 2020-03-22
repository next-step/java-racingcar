import java.util.Random;

public class GameProgress {

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;

    public void progress(RacingGame game) {
        for (int i = 0; i < game.getTime(); i++) {
            move(game);
            game.resultView();
            System.out.println("");
        }
    }

    public int[] move(RacingGame game) {
        Random random = new Random();

        for (int i = 0; i < game.getCarPosition().length; i++) {
            int ranCount = random.nextInt(RANDOM_BOUND);
            if (ranCount >= BASE_POINT) {
                game.getCarPosition()[i] = game.getCarPosition()[i] + DISTANCE;
            }
        }

        return game.getCarPosition();
    }
}
