package study.race.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private int maxDistance;
    private List<String> winnerList;

    public Winners(int maxDistance) {
        this.maxDistance = maxDistance;
        this.winnerList = new ArrayList<>();
    }

    public void checkAndAddWinner(String name, int distance) {
        if (isWinner(distance)) {
            addToWinnerList(name);
        }
    }

    private boolean isWinner(int distance) {
        return distance >= maxDistance;
    }

    private void addToWinnerList(String name) {
        this.winnerList.add(name);
    }

    public String getWinnersList() {
       String winners = "";
        for (String winner : this.winnerList) {
          winners = winners + winner + ", ";
        }
        return winners.substring(0, winners.length() - 2);
    }
}
