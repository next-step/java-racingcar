package racingcar;

import java.util.stream.Stream;
import racingcar.domain.car.Car;
import racingcar.domain.car.Move;
import racingcar.domain.Participants;
import racingcar.domain.RacingResult;
import racingcar.domain.random.RandomGenerator;

public class RacingController {

    private static final String HEAD_MESSAGE = "\n실행 결과";
    private final Participants participants;
    private final Printer printer = new Printer();

    private final int turnCount;
    private final Move move;

    public RacingController(Participants participants, int turn) {
        this.participants = participants;
        this.turnCount = turn;
        this.move = new Move();
    }

    public void start() {
        System.out.println(HEAD_MESSAGE);
        RacingResult racingResult = new RacingResult(participants);

        for (int i = 0; i < turnCount; i++) {
            racingResult = race(racingResult);
            printer.getResultView(participants);
        }
    }

    public RacingResult race(RacingResult result) {
        for (int i = 0; i < participants.count(); i++) {
            boolean bool = move.isSatisfiedMoveCondition(new RandomGenerator());
            result.moveCarIfPositionChanged(i, bool);
        }
        return result;
    }

    public void end() {
        Stream<String> winnersName = participants.getWinners().map(Car::getName);
        printer.printFinalWinners(winnersName);
    }
}
