package step_3;

public class RacingGameApplication {
    public static void main(String[] args) {
        new RacingGameApplication().run(args);
    }

    public void run(String[] args) {
        RacingGameConditions racingGameConditions = new RacingGameConditions();
        new RacingGame(racingGameConditions).gameStart();
    }
}
