package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private RacingGame racingGame;
    private MoveCondition defaultCondition;
    private String defaultCarName;

    @BeforeEach
    void setUp() {
        this.defaultCondition = MoveConditions.randomCondition();
        this.defaultCarName = "자동차1";
    }

    @Test
    void testNoMovement() {
        // 랜덤값 4 미만일 시(e.g. 3) Car의 position은 변하지 않아야 함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Car car = new Car(defaultCarName, defaultCondition);

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition, car.getPosition());
    }

    @Test
    void testMoveForward() {
        // 랜덤값 4 이상일 시(e.g. 4) Car의 position은 1씩 증가해야함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        Car car = new Car(defaultCarName, defaultCondition);

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition+1, car.getPosition());
    }

    @Test
    void testInitialPosition() {
        // 자동차가 처음 생성될 때 초기 위치가 1인지 확인
        Car car = new Car(defaultCarName, defaultCondition);

        assertEquals(1, car.getPosition(), "자동차의 초기 위치는 1이어야 합니다.");
    }

    @Test
    void testCarMovementConditionChange () {
        MoveCondition alwaysMove = () -> true;
        Car car = new Car(defaultCarName, alwaysMove);

        int initialPosition = car.getPosition();
        car.move();
        car.move();
        car.move();

        assertEquals(initialPosition + 3, car.getPosition(), "자동차는 항상 이동해야 합니다.");
    }
}
