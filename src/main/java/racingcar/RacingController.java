package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RandomManager;
import racingcar.domain.car.Car;
import racingcar.domain.car.Move;
import racingcar.domain.Participants;
import racingcar.domain.RacingResult;

public class RacingController {

    private static final int BOUND = 4;
    private static final String HEAD_MESSAGE = "\n실행 결과";
    private Participants participants;
    private final int turnCount;
    private final int participantCount;

    public RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
        participantCount = participants.getParticipantCount();
    }

    public static RacingController getInstance(Participants participants, int turn) {
        return new RacingController(participants, turn);
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingResult racingResult = RacingResult.getInstance(participants.getParticipants());
        for (int i = 0; i < turnCount; i++) {
            racingResult = race(racingResult);
            racingResult.getResultView();
        }
        racingResult.getWinner();
    }

    public RacingResult race(RacingResult result) {
        List<Car> newCars = new ArrayList<>();
        for (int i = 0; i < participantCount; i++) {
            newCars.add(Move.isSatisfiedMoveCondition(result.getCars().get(i), RandomManager.get()));
        }
        return RacingResult.getInstance(newCars);
    }
}
