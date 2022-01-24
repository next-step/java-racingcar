package racinggame.domain;

import java.io.IOException;
import java.util.List;
import racinggame.view.GameView;

public class RacingGame {
    private static final String QUIT = "q";

    private GameView gameView;
    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {}

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.gameView = new GameView(racingCars);
        this.racingCars = racingCars;
        this.trial = trial;
    }

    public void start() throws IOException {
        for (int i = 0; i < trial; i++) {
            System.out.println("그만 하시려면 q, 계속하시려면 아무키나 입력해 주세요.");
            String input = Utils.getInput();

            if (isEnd(input)) {
                System.exit(0);
            }

            progress();
            gameView.printProgress();
        }

        gameView.printWinners();
    }
    private boolean isEnd(String input) {
        return input.equals(QUIT);
    }

    private void progress() {
        racingCars.forEach(car -> {
            int randomValue = getRandomValue();
            if (car.canForward(randomValue)) {
                car.forward();
            }
        });
    }

    public int getRandomValue() {
        int random = (int) Math.floor(Math.random() * (9 - 0 + 1));
        return random;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    protected int getTrial() {
        return this.trial;
    }
}
