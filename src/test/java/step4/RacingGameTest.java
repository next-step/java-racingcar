package step4;

import org.junit.jupiter.api.Test;
import step3.Car;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private RacingGame racingGame;

    @Test
    void testNoMovement() {
        // 랜덤값 4 미만일 시(e.g. 3) Car의 position은 변하지 않아야 함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        step3.Car car = new step3.Car();

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
        step3.Car car = new Car();

        int initialPosition = car.getPosition(); // 초기 시작 위치: 1
        car.move();

        assertEquals(initialPosition+1, car.getPosition());
    }

    @Test
    void testCarMovementConditionChange () {

    }

    @Test
    void testCarNameLength () {
        // 각 자동차 이름은 5자를 초과할 수 없다.

    }

    @Test
    void testCarNameValidation() {
        // 올바르지 않은 이름 입력 형식
    }

    @Test
    void testWinner() {
        // 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
    }
}
