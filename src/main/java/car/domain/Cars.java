package car.domain;

import car.ui.View;
import car.ui.Winner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> participants;

    private Cars(List<Car> participants) {
        this.participants = participants;
    }

    public static Cars of(String carNames) {
        List<Car> participants = validateCarNames(carNames);
        return new Cars(participants);
    }

    private static List<Car> validateCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Winner> getWinners() {
        int maxPosition = getMaxPosition();
        return participants.stream()
                .filter(participant -> participant.isEqualPosition(maxPosition))
                .map(Winner::from)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return participants.stream()
                .mapToInt(Car::findPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void printPositionInfo() {
        List<View> views = this.participants.stream()
                .map(View::from)
                .collect(Collectors.toList());

        views.forEach(View::printStatus);
        System.out.println();
    }
}
