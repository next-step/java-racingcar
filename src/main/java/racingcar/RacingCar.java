package racingcar;

import java.util.Random;

public class RacingCar {
    private final Random random;
    private final int[] histories;
    private static final int RANDOM_NUMBER_BOUND = 9;
    private static final int NUMBER_FOR_DECISION_OF_STRAIGHT = 4;

    public RacingCar(Random random, int count) {
        this.random = random;
        if(count < 0 || count > 99) {
            throw new RuntimeException("count는 1에서 99까지의 숫자만 입력가능합니다.");
        }
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
            int ranNum = random.nextInt(RANDOM_NUMBER_BOUND);
            histories[i] = straightOrStop(ranNum);
        }
    }

    private int straightOrStop(int randomNumber) {
        if(randomNumber >= NUMBER_FOR_DECISION_OF_STRAIGHT) {
            return 1;
        }
        return 0;
    }
}
