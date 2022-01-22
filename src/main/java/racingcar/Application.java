package racingcar;

import racingcar.view.UserInput;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance(UserInput.createCars(), UserInput.setTurn());
        racingController.start();
    }
}