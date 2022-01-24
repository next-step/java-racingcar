package racingcar;

import java.util.stream.Stream;
import racingcar.domain.car.Car;
import racingcar.domain.car.Move;
import racingcar.domain.Participants;
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
        for (int i = 0; i < turnCount; i++) {
            race();
            printer.getResultView(participants);
        }
    }

    public void race() {
        for (int i = 0; i < participants.count(); i++) {
            boolean condition = move.isSatisfiedMoveCondition(new RandomGenerator());
            moveCarIfConditionIsSatisfied(i, condition);
        }
    }

    public void end() {
        Stream<String> winnersName = participants.getWinners().map(Car::getName);
        printer.printFinalWinners(winnersName);
    }

    public void moveCarIfConditionIsSatisfied(int index, boolean condition) {
        if (condition) {
            participants.get(index).go();
        }
    }
}
