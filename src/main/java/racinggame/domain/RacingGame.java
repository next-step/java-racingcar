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
            System.out.println("계속 진행 하려면 아무키나 입력해 주세요.(종료 = q)");
            String command = Utils.getInput();

            if (isQuit(command)) {
                System.exit(0);
            }
            progress();

            gameView.printProgress();
        }
        gameView.printWinners();
    }

    public static boolean isQuit(String command) {
        return command.equals(QUIT);
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
