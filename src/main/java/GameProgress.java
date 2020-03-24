import java.util.Random;

public class GameProgress {

    private final int BASE_POINT = 4;
    private final int RANDOM_BOUND = 10;
    private final int DISTANCE = 1;
    private final int ZERO = 0;
    private final String SPLIT_CHAR = ",";

    public void progress(RacingGame racingGame) {

        OutputView output = new OutputView();
        System.out.println("실행 결과");
        for (int i = 0; i < racingGame.getTime(); i++) {
            move(racingGame);
            output.resultView(racingGame);
            System.out.println("");
        }

        showWinner(racingGame);
    }

    public void move(RacingGame racingGame) {
        Random random = new Random();

        for (int i = 0; i < racingGame.getCars().length; i++) {
            int ranCount = random.nextInt(RANDOM_BOUND);
            int position = racingGame.getCars()[i].getPosition();
            racingGame.getCars()[i].setPosition( position += (ranCount >= BASE_POINT) ? DISTANCE : ZERO);
        }
    }

    public void showWinner(RacingGame racingGame) {
        int max = 0;
        for (int i = 0; i < racingGame.getCars().length; i++) {
            max = Math.max(racingGame.getCars()[i].getPosition(), max);
        }

        String winners = "";
        for (int i = 0; i < racingGame.getCars().length; i++) {
            winners += (racingGame.getCars()[i].getPosition() == max) ? racingGame.getCars()[i].getName() + SPLIT_CHAR : "";
        }

        winners = winners.substring(0, winners.length() - 1);

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
