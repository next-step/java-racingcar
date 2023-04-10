package racingcar;

import java.util.Random;

public class Car {
    public static final int MOVABLE_BASE_NUMBER = 4;
    public static final int RANDOM_RANGE = 10;
    public static final String POSITION_MAKER = "-";
    private int position;
    private final Random random;

    public Car(Random random) {
        this.random = random;
    }

    public void move() {
        if (isMovable()) {
            position++;

        }
    }
    public boolean isMovable() {
        return random.nextInt(RANDOM_RANGE) >= MOVABLE_BASE_NUMBER;
    }

    // 해당 메소드는 getter, setter 사용을 안하려고 하다보니 만들게 되었는데, 테스트 코드에서만 쓰고 있습니다! 테스트 코드만을 위해 만든 메소드인데 좋은 선택이었을까요??
    public boolean hasPositioned(int position) {
        return this.position == position;
    }

    public void view() {
        for (int i = 0; i < position; i++) {
            System.out.print(POSITION_MAKER);
        }
        System.out.println();
    }
}
