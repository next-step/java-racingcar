package car;

public class CarApplication {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());
        racingGame.startRacingGame();
    }
}
