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

    public void addWinners(String name, int distance) {
        if (distance >= maxDistance) {
            this.winnerList.add(name);
        }
    }

    public String getString() {
        String winnerToString = "";
        for (String winner: this.winnerList) {
            winnerToString = winnerToString + winner + ", ";
        }
        return winnerToString.substring(0, winnerToString.length() - 2);
    }
}
