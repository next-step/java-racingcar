package model;

import java.util.HashSet;
import java.util.Set;

public class WinnerInfo {
    private final Set<String> winnerNames;
    private final int winnerPosition;

    public WinnerInfo(int winnerPosition) {
        this.winnerNames = new HashSet<>();
        this.winnerPosition = winnerPosition;
    }

    public void addWinnerIfMatchingPosition(Car car) {
        if (car.getPosition() == winnerPosition) {
            winnerNames.add(car.getName());
        }
    }

    public Set<String> getWinnerNames() {
        return winnerNames;
    }
}