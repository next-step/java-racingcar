package racingcar;

import racingcar.domain.Participants;
import racingcar.domain.Turns;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance(Participants.createCars(), Turns.setTurn());
        racingController.start();
    }
}