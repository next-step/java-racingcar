package game.gambling.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusik on 2019/10/29.
 */
public class GamblingResult {

    private List<String> winners = new ArrayList<>();

    public void addWinner(String winner) {
        winners.add(winner);
    }

    public List<String> getWinners() {
        return winners;
    }
}
