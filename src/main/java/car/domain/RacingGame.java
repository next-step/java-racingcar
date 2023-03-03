package car.domain;

import car.Car;
import car.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public List<Car> play(List<Car> participants, int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            participants.forEach(participant -> {
                int randomValue = RandomUtils.generateRandomValue();
                participant.move(randomValue);
            });
            System.out.println();
        }

        int max = getMaxPosition(participants);
        return getWinners(participants, max);
    }

    private List<Car> getWinners(List<Car> participants, int max) {
        List<Car> winners = new ArrayList<Car>();

        for (Car car : participants) {
            if (max == car.getPosition()) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int getMaxPosition(List<Car> participants) {

        int max = 0;

        for (Car car : participants) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }

        return max;
    }
}
