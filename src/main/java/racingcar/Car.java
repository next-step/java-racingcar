package racingcar;

import java.util.Arrays;

public class Car {
    private final String name;
    private final int[] histories;

    public Car(String name, int count) {
        this.name = name;

        CarValidator.validateCount(count);
        CarValidator.validateName(name);

        this.histories = new int[count];
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

    public String getName() {
        return this.name;
    }

    public void run(int countIndex) {
        if(countIndex < 0 || countIndex >= histories.length) {
            throw new RuntimeException("잘못된 count의 index값입니다.");
        }
        int result = RandomNumberMovingStrategy.move();
        histories[countIndex] = result;
    }

    public int getTotalStraightCount() {
        return Arrays.stream(histories).sum();
    }

}
