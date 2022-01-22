package racingcar;

import racingcar.domain.Participants;

public class Application {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        String[] carNames = userInput.getCarNames();
        int turn = userInput.getTurn();

        Participants participants = new Participants(carNames);

        RacingController racingController = RacingController.getInstance(participants, turn);
        racingController.start();
    }
}