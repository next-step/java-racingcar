package step3;

import java.util.Random;

public class RacingCar {

    private int numberOfCar;
    private int numberOfTrial;

    public void setInput(InputDto inputDto) {
        this.numberOfCar = inputDto.getNumberOfCar();
        this.numberOfTrial = inputDto.getNumberOfTrial();
    }

    public int[][] getRandomValue() {
        Random random = new Random();
        int[][] results = new int[numberOfTrial][numberOfCar];

        for (int i = 0; i < numberOfTrial; i++) {
            for (int j = 0; j < numberOfCar; j++) {
                results[i][j] = random.nextInt(10);

                if (0 < i) {
                    results[i][j] += results[i - 1][j];
                }
            }
        }
        return results;
    }

}
