package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    /*
    @DisplayName("Move 테스트")
    @Test
    public void moveTest() {
        int beforeLocationValue = car.getLocation().getValue();
        for (int moveValue = 0; moveValue < 100; moveValue++) { // moveValue만큼 이동 시킨 후 실제로 Location의 값이 변경 되었는지 테스트
            car.move(moveValue);
            assertThat(car.getLocation().getValue() - beforeLocationValue)
                    .isEqualTo(moveValue);
            beforeLocationValue = car.getLocation().getValue();
        }
    }
     */

    @ValueSource(ints = {
            100, 1000, 10000, 100000, 10000000
    })
    @DisplayName("Random Move 테스트")
    @ParameterizedTest
    public void randomMoveTest(int limitMoveCount) {
        int emptyMoveCount = 0;

        Car car = new Car();
        for (int i = 0; i < limitMoveCount; i++) {
            car.move();
            if (!car.getLastMoveDistance().hasValue())
                ++emptyMoveCount;
        }
        assertThat(car.getMoveCount())
                .withFailMessage("지정한 횟수만큼 이동하지 않았습니다.")
                .isEqualTo(limitMoveCount);

        assertThat(emptyMoveCount)
                .withFailMessage("0만큼 이동한 횟수가 없습니다.")
                .isNotEqualTo(0);
    }
}