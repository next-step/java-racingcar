package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.Turn;

public class Application {

    public static void main(String[] args) {
        Participants participants = Participants.createCars();
        Turn turn = Turn.getInstance();

        RacingController racingController = RacingController.getInstance(participants, turn.getValue());
        racingController.start();
    }
}