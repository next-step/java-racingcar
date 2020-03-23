package racingcar;

public class RacingGame {

    private int time;
    private int[] carPositions;
    private int[][] result;

    public RacingGame(int numberOfTry, int numberOfCars) {
        this.time = numberOfTry;
        this.carPositions = new int[numberOfCars];
        this.result = new int[numberOfTry][numberOfCars];
    }

    public int[][] run() {
        return result.clone();
    }
}
