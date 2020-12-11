package step3;

public class App {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        int carCount = inputHandler.getCarCount();
        int roundCount = inputHandler.getRoundCount();
        RacingGame game = new RacingGame(carCount);
        for (int i = 0; i < roundCount; i++) {
            game.play();
            System.out.println(game.getPlayResult());
        }
    }
}
