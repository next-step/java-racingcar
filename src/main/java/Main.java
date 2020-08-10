import mvc.controller.RacingGameController;

public class Main {

    public static void main(String[] args) {
        RacingGameController controller = RacingGameController.createGameController();
        controller.start();
    }
}
