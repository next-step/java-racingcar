package car.domain;

import car.domain.condition.RacingCondition;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RacingCondition racingCondition;

    public RacingGame(RacingCondition racingCondition) {
        this.racingCondition = racingCondition;
    }

    public List<Car> play(List<Car> participants, int moveCount) {
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
        String status = car.printStatus();
        System.out.println(status);
    }

    public List<Car> getWinners(List<Car> participants, int maxPosition) {
        return participants.stream().
                filter(participant -> participant.isEqualPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> participants) {
        return participants.stream()
                .mapToInt(Car::findPosition)
                .max()
                .getAsInt();
    }
}
