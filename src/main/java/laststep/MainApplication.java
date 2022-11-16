package laststep;

import laststep.controller.GameController;

public class MainApplication {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.start();
    }
}
