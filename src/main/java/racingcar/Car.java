package racingcar;

import java.util.Arrays;

public class Car {
    private final String name;
    private final int[] histories;

    public Car(String name, int count) {
        this.name = name;

        validateCount(count);
        validateName(name);

        this.histories = new int[count];
    }

    private void validateCount(int count) {
        if(count < 0 || count > 99) {
            throw new RuntimeException("count는 1에서 99까지의 숫자만 입력가능합니다.");
        }
    }

    private void validateName(String name) {
        if(name == null || name.isBlank()) {
            throw new RuntimeException("name은 필수값이고 공백문자만 사용이 불가합니다.");
        }
        if(name.length() > 10) {
            throw new RuntimeException("name은 1자에서 10자까지 입력가능합니다.");
        }
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

    public void run(int index) {
        int result = RandomNumberMovingStrategy.straightOrStop();
        histories[index] = result;
    }

    public int getTotalStraightCount() {
        return Arrays.stream(histories).sum();
    }

}
