import controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController gameEngine = new RacingGameController();
        gameEngine.init();

        gameEngine.play();
    }
}
