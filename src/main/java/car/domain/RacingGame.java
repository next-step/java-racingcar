package car.domain;

import car.domain.condition.RacingCondition;
import car.ui.GameRequest;
import car.ui.View;
import car.ui.Winner;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RacingCondition racingCondition;

    public RacingGame(RacingCondition racingCondition) {
        this.racingCondition = racingCondition;
    }

    public List<Winner> play(final GameRequest request) {
        int moveCount = request.getMoveCount();
        List<Car> participants = request.getParticipants();

        for (int i = 0; i < moveCount; i++) {
            startMove(participants);
        }

        int maxPosition = getMaxPosition(participants);
        return getWinners(participants, maxPosition);
    }

    private void startMove(List<Car> participants) {
        participants.forEach(this::checkCondition);
        System.out.println();
    }

    private void checkCondition(Car car) {
        if (racingCondition.isSatisfied()) {
            car.move();
        }

        View view = car.toView();
        String status = view.printStatus();
        System.out.println(status);
    }

    public List<Winner> getWinners(List<Car> participants, int maxPosition) {
        return participants.stream()
                .filter(participant -> participant.isEqualPosition(maxPosition))
                .map(Car::toWinner)
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> participants) {
        return participants.stream()
                .mapToInt(Car::findPosition)
                .max()
                .getAsInt();
    }
}
