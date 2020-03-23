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
        drive();
        return result.clone();
    }

    public void drive() {
        for(int i=0; i<result.length; i++) {
            carPositions[0]++;
            carPositions[1]++;
            carPositions[2]++;

            result[i][0] = carPositions[0];
            result[i][1] = carPositions[1];
            result[i][2] = carPositions[2];
        }
    }
}
