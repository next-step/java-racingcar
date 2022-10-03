package racingcar;

import java.util.Random;

public class RacingCar {
    private final Random random;
    private final int[] histories;

    public RacingCar(Random random, int count) {
        this.random = random;
        this.histories = new int[count];
        initHistories();
    }

    public int getHistoriesByIndex(int index) {
        if(index < 0 || index >= histories.length) {
            throw new RuntimeException("index 값이 올바르지 않습니다.");
        }
        return histories[index];
    }

    public int getHistoryCount() {
        return this.histories.length;
    }

    private void initHistories() {
        for(int i=0 ; i<histories.length ; i++) {
            int ranNum = random.nextInt(9);
            histories[i] = straightOrStop(ranNum);
        }
    }

    private int straightOrStop(int randomNumber) {
        if(randomNumber >= 4) {
            return 1;
        }
        return 0;
    }
}
