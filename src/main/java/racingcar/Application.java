package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;
import racingcar.domain.dto.ParticipantsRequestDto;
import racingcar.domain.dto.TurnRequestDto;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        Participants participants = setParticipants();
        int turnCount = setTurn().getValue();

        RacingController racingController = RacingController.getInstance(participants, turnCount);
        racingController.start();
        racingController.printGameResult();
    }

    public static Participants setParticipants() {
        try {
            return ParticipantsRequestDto.toEntity(InputView.setNames());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return setParticipants();
        }
    }

    public static Turn setTurn() {
        try {
            return TurnRequestDto.toEntity(InputView.setTurnCount());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return setTurn();
        }
    }
}