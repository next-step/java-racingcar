package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.CarRacingProperty.MAX_RANDOM_DISTANCE;
import static racing.CarRacingProperty.MIN_MOVABLE_DISTANCE;

public class CarRacingTest {

    @ParameterizedTest
    @CsvSource(value = {
        "3,5", "5,3"
    })
    @DisplayName("정상적인 입력값으로 정상적으로 수행하고 초기화하는지 테스트")
    public void should_success_when_normalInput(int carCount, int tryCount) {
        CarRacing carRacing = new CarRacing(carCount, tryCount);
        carRacing.start();

        assertThat(carRacing.isRacingComplete()).isTrue();
        assertThat(carRacing.getCarCount()).isEqualTo(carCount);
        assertThat(carRacing.getRacingCount()).isEqualTo(tryCount);
    }

    @Test
    @DisplayName("차 이동 거리가 설정한 최소값 이상이고 설정한 랜덤값 범위 내에 속하는지?")
    public void should_carMovedDistance_expect_withinSetLimits() {
        new CarRacing(3, 5).start(new CarRacingListener() {

            @Override
            public void carMoved(int movedDistance) {
                assertThat(movedDistance).isBetween(MIN_MOVABLE_DISTANCE, MAX_RANDOM_DISTANCE);
            }

            @Override
            public void carMovedComplete(int totalDistance) {}

            @Override
            public void racingTriedComplete() {}
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0", "5,0", "0,5", "-10,-10", "5,-10", "-10,5"
    })
    @DisplayName("0 이하의 입력값으로 정상적으로 레이싱하지 않고 종료하는지 테스트")
    public void should_success_when_invalidInput(int carCount, int tryCount) {
        CarRacing racing = new CarRacing(carCount, tryCount);
        racing.start();
        assertThat(racing.isRacingComplete()).isTrue();
        assertThat(racing.getCarCount()).isEqualTo(0);
        assertThat(racing.getRacingCount()).isEqualTo(0);
    }

}
