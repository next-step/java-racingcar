package racing;

import java.util.Random;

public class Car {

    private static final Random random = new Random();
    private static final Integer RANDOM_BOUND = 10;

    private int position;
    private final int moveCount;

    public Car(int position, int moveCount) {
        this.position = position;
        this.moveCount = moveCount;
    }

    public void moveToFinish() {
        for (int i = 0; i < moveCount; i++) {
            move(random.nextInt(RANDOM_BOUND));
        }
    }

    public void move(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        if (randomNumber >= 4) {
            position += 1;
        }
    }

    public int moveCount() { // 테스트 코드에서 검증이 필요해서 넣음
        return moveCount;
    }

    public int position() {
        return position;
    }
}
