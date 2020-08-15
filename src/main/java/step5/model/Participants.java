package step5.model;

import step5.streategy.MovementStrategy;
import step5.streategy.RacingGameMovementStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Participants {
    private final List<Car> participants;

    public Participants(List<Car> participants) {
        this.participants = participants;
    }

    public int getNumberOfCars() {
        return participants.size();
    }

    public int getCurrentMaximumScoreFromParticipants() {
        return participants
                .stream()
                .max(Comparator.comparing(Car::getDistance))
                .map(Car::getDistance)
                .get();
    }

    public List<String> getWinnerMember() {
        List<String> winnerMembers = new ArrayList<>();
        int maxScore = getCurrentMaximumScoreFromParticipants();
        for (Car car : participants) {
            winnerMembers.add(findWinnerPlayer(maxScore, car));
        }
        return winnerMembers;
    }

    private String findWinnerPlayer(int maxScore, Car car) {
        if (car.getDistance() == maxScore) {
            return car.getName();
        }
        return null;
    }

    public void moveCarWithStrategy(MovementStrategy movementStrategy) {
        for (Car car : participants) {
            car.moveWithStrategy(movementStrategy);
        }
    }

    public List<String> getMemberOfParticipants() {
        return Arrays.asList(participants.stream()
                .map(Car::getName)
                .toArray(String[]::new));
    }
}
