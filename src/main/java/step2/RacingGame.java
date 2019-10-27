package step2;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public RacingGame() {

    }

    public int[] carPositionsInitiate(int createCarCount) {
        this.carPositions = new int[createCarCount];
        return carPositions;
    }


}
