package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차 이동 실패 조건(0~3) 테스트")
    void moveFailConditionTest(int value) {
        Car car = new Car("kim");
        assertThat(car.canMove(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차 이동 성공 조건(4~9) 테스트")
    void moveSuccessConditionTest(int value) {
        Car car = new Car("kim");
        assertThat(car.canMove(value)).isTrue();
    }


    @Test
    @DisplayName("자동차 이동 테스트")
    void moveCarTest() {
        final int MOVE_DISTANCE = 1;
        Car car = new Car("kim");
        car.move();
        assertThat(car.getLocation()).isEqualTo(MOVE_DISTANCE);
    }

    @Test
    @DisplayName("우승자인 경우 우승 여부 확인 테스트")
    void isWinnerTest_winner() {
        int winnerLocation = 4;
        Car car = new Car("kim", 4);

        assertThat(car.isWinner(winnerLocation)).isTrue();
    }

    @Test
    @DisplayName("우승자가 아닌 경우 우승 여부 확인 테스트")
    void isWinnerTest_loser() {
        int winnerLocation = 4;
        Car car = new Car("lee", 3);

        assertThat(car.isWinner(winnerLocation)).isFalse();
    }
}
