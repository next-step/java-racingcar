package car.domain;

import car.Car;
import car.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public List<Car> play(List<Car> participants, int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            startMoveRandomly(participants);
        }

        int maxPosition = getMaxPosition(participants);
        return getWinners(participants, maxPosition);
    }

    private void startMoveRandomly(List<Car> participants) {
        participants.forEach(participant -> {
            int randomValue = RandomUtils.generateRandomValue();
            participant.move(randomValue);
        });
        System.out.println();
    }

    private List<Car> getWinners(List<Car> participants, int maxPosition) {
        return participants.stream().
                filter(participant -> maxPosition == participant.getPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> participants) {

        int maxPosition = 0;

        for (Car car : participants) {
            maxPosition = calcMaxPosition(maxPosition, car);
        }

        return maxPosition;
    }

    private int calcMaxPosition(int maxPosition, Car car) {
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
