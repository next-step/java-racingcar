package car.domain;

import car.Car;
import car.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int COND_VAL = 10;

    public List<Car> play(List<Car> participants, int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            startMoveRandomly(participants);
        }

        int maxPosition = getMaxPosition(participants);
        return getWinners(participants, maxPosition);
    }

    private void startMoveRandomly(List<Car> participants) {
        participants.forEach(participant -> {
            int randomValue = RandomUtils.generateRandomValueBy(COND_VAL);
            participant.move(randomValue);
        });
        System.out.println();
    }

    public List<Car> getWinners(List<Car> participants, int maxPosition) {
        return participants.stream().
                filter(participant -> participant.isEqualPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> participants) {

        int maxPosition = 0;

        for (Car car : participants) {
            maxPosition = calcMaxPosition(maxPosition, car);
        }

        return maxPosition;
    }

    private int calcMaxPosition(int maxPosition, Car car) {
        if (car.isGreaterThan(maxPosition)) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
