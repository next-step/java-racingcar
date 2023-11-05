package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차의 현재 위치를 나타내는 문자열 생성")
    public void currentPosition() {
        Car mySummerCar = new Car(5);

        assertThat(mySummerCar.getMoveTrajectory())
                .isEqualTo("-----");
    }

    @Test
    @DisplayName("자동차 움직이기 테스트")
    public void moveCar() {
        Car mySummerCar = new Car(1);

        mySummerCar.move(4);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(5);

        mySummerCar.move(0);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(5);

        mySummerCar.move(-2);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(3);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            mySummerCar.move(-5);
        });
    }

    @Test
    @DisplayName("비결정론적 자동차 움직이기 테스트")
    public void nondeterministicMove() {
        // 테스트 정확도 조절 변수 모음
        final int TEST_COUNT = 100000;
        final double ASSERT_OFFSET = 0.01;
        final double EXPECTED_MOVE_PROBABILITY = 0.6;

        Car mySummerCar = new Car(1);

        int lastPosition = 1;
        int moveCount = 0;
        for (int testNumber = 1; testNumber <= TEST_COUNT; testNumber++) {
            // 이동 확률 계산하기 위한 10만번 반복 테스트
            mySummerCar.go();

            if (mySummerCar.getPosition() > lastPosition) {
                lastPosition = mySummerCar.getPosition();
                moveCount += 1;
            }
        }

        // 이동 빈도가 이론 상 확률에 근접해야 함.
        assertThat((double) moveCount / (double) TEST_COUNT)
                .isCloseTo(EXPECTED_MOVE_PROBABILITY, within(ASSERT_OFFSET));
    }
}
