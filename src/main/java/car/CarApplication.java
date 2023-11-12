package car;

public class CarApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController(new RacingGame(new RandomNumberGenerator()));
        gameController.startRacingGame();
    }
}
