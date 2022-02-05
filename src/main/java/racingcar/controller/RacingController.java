package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;
import racingcar.domain.dto.ParticipantsRequestDto;
import racingcar.domain.dto.TurnRequestDto;
import racingcar.domain.racing.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RacingRecord;

public class RacingController {

    public void start() {
        RacingGame racingGame = makeRacingGame();

        List<Participants> racingResult = racingGame.start();

        printRacingRecord(racingResult);
        printWinner(racingResult);
    }

    private RacingGame makeRacingGame() {
        try {
            return new RacingGame(makeParticipants(), makeTurnCount());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return makeRacingGame();
        }
    }

    private Participants makeParticipants() {
        ParticipantsRequestDto participantsRequestDto = InputView.setNames();
        return participantsRequestDto.toEntity();
    }

    private Turn makeTurnCount() {
        TurnRequestDto turnRequestDto = InputView.setTurnCount();
        return turnRequestDto.toEntity();
    }

    public void printRacingRecord(final List<Participants> cars) {
        for (Participants participants : cars) {
            RacingRecord.appendRecord(participants.getParticipants());
        }
        OutputView.printRacingResult(RacingRecord.getResultRecord());
    }

    public void printWinner(final List<Participants> cars) {
        OutputView.printWinner(cars.get(cars.size() - 1).findWinners());
    }
}
