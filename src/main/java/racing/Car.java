package racing;

import java.util.Random;

public class Car {

    private static final Random random = new Random();
    private static final Integer RANDOM_BOUND = 10;
    private static final Integer DEFAULT_POSITION = 0;
    private static final Integer MOVE_CRITERIA = 4;
    private static final Integer MAX_RANDOM = 9;

    private int position;
    private final int moveCount;

    public Car(int moveCount) {
        this.position = DEFAULT_POSITION;
        this.moveCount = moveCount;
    }

    public void moveToFinish() {
        for (int i = 0; i < moveCount; i++) {
            move(random.nextInt(RANDOM_BOUND));
        }
    }

    public void move(int randomNumber) {
        if (randomNumber < 0 || randomNumber > MAX_RANDOM) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        if (randomNumber >= MOVE_CRITERIA) {
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
