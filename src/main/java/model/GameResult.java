package model;


import java.util.List;

public class GameResult {

    private final List<Integer> carPositions;

    public GameResult(List<Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
