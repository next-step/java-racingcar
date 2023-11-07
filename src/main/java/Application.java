import racing.RacingGameEngine;

public class Application {
    public static void main(String[] args) {
        RacingGameEngine gameEngine = new RacingGameEngine();
        gameEngine.init();

        gameEngine.play();
    }
}
