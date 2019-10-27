package step2;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public RacingGame() {

    }

    public int[] carPositionsInitiate(int createCarCount) {
        this.carPositions = new int[createCarCount];
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] = 0;
        }
        return carPositions;
    }


}
