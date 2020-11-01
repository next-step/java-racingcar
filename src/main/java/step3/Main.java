package step3;

import step3.controller.InputController;

public class Main {

    public static void main(String[] args) {

        InputController inputController = new InputController();
        RacingSpec spec = inputController.enterInput();

    }
}
