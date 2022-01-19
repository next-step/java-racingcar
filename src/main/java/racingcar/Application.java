package racingcar;

import racingcar.domain.Participants;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance(UserInput.createCars(), UserInput.setTurn());
        racingController.start();
    }
}