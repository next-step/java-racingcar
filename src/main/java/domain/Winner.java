package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    List<Car> winners;

    public void createWinnersData(List<Car> participant, int winnerDistance) {
        winners = new ArrayList<>(participant);
        winners.removeIf(winner -> winner.readCarDistance() != winnerDistance);
    }

    public List<Car> readWinners() {
        return winners;
    }

}
