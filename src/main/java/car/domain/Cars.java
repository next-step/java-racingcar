package car.domain;

import car.ui.Winner;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> participants;

    private Cars(List<Car> participants) {
        this.participants = participants;
    }

    public static Cars of(List<Car> participants) {
        return new Cars(participants);
    }

    public List<Winner> getWinners() {
        int maxPosition = getMaxPosition();
        return participants.stream()
                .filter(participant -> participant.isEqualPosition(maxPosition))
                .map(Winner::from)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return participants.stream()
                .mapToInt(Car::findPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getParticipants() {
        return participants;
    }
}
