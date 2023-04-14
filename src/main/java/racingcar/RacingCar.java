package racingcar;

import java.util.Random;

public class RacingCar {

    private static final int BOUND = 10;
    private static final int PROCEEDING_NUM = 4;

    private static final int INIT_VALUE_ONE = 1;

    private final Random random = new Random();
    private final ResultView resultView = new ResultView();

    private final int[][] car;

    RacingCar(int carCount, int trialCount) {
        car = new int[carCount][trialCount];
    }

    public int proceed() {
        int number = random.nextInt(BOUND);
        return number >= PROCEEDING_NUM ? 1 : 0;
    }

    public void race() {
        for(int[] row : car) {
            row[0] = INIT_VALUE_ONE; // 출발점이 1인 것 같아서 1로 초기화했다.
            for(int j=1; j < row.length; j++) {
                row[j] += row[j-1] + proceed();
            }
        }
    }

    public void showResult() {
        resultView.showResult(car);
    }
}
