import controller.GameController;

public class RacingGame {

    public static void main(String[] args) {

        try {
            new GameController().playRacingGame();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
