package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetermineResult {
    private boolean checkSame(Car toCompare, int winnerPosition) {
        if (toCompare.getMovingRange() == winnerPosition) {
            return true;
        }
        return false;
    }

    public List<String> setWinner(Players players) {
        Collections.sort(players.getCars());
        List<String> winner = new ArrayList<>();

        for (Car car : players.getCars()) {
            if (checkSame(car, players.getCars().get(0).getMovingRange())) {
                winner.add(car.getName());
            }
        }

        return winner;
    }
}
