package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;

public class Application {

    public static void main(String[] args) {
        Participants participants = Participants.createCars();
        Turn turn = Turn.getInstance();

        RacingController racingController = RacingController.getInstance(participants, turn.getValue());
        racingController.start();
    }
}