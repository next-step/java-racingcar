package step3;

import step3.controller.GameController;
import step3.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int countOfCars = inputView.getCountOfCars();
        int countOfTry = inputView.getCountOfTry();

        GameController controller = GameController.newInstance();
    }
}
