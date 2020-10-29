package step3;

import step3.controller.InputController;
import step3.controller.OutputController;

public class App{
    public static void main(String[] args) {
        int carCount = InputController.putCarCount();
        int tryCount = InputController.putTryCount();

        OutputController.runResult();
    }

}
