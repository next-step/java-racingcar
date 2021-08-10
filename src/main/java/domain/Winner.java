package domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winner {

    private static final int WINNER_POSITION = 0;
    List<Car> winners;

    public void createWinnersData(List<Car> participant) {
        winners = new ArrayList<>(participant);
        winners.sort(Comparator.comparing(Car::readCarDistance).reversed());
        winners.removeIf(winner -> winner.readCarDistance() != winners.get(WINNER_POSITION).readCarDistance());
    }

    public List<Car> readWinners() {
        return winners;
    }

}
