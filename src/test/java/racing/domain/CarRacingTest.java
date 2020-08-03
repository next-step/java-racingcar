package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @ParameterizedTest
    @CsvSource(value = {
        "3,5", "5,3"
    })
    @DisplayName("정상적인 입력값으로 정상적으로 수행하고 초기화하는지 테스트")
    public void should_success_when_normalInput(int carCount, int raceCount) {
        CarRacing carRacing = new CarRacing(carCount, raceCount);
        while (!carRacing.isComplete()) {
            carRacing.race();
        }

        assertThat(carRacing.isComplete()).isTrue();
        assertThat(carRacing.getCarCount()).isEqualTo(carCount);
        assertThat(carRacing.getRacingCount()).isEqualTo(raceCount);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0", "5,0", "0,5", "-10,-10", "5,-10", "-10,5"
    })
    @DisplayName("0 이하의 입력값으로 정상적으로 레이싱하지 않고 종료하는지 테스트")
    public void should_success_when_invalidInput(int carCount, int tryCount) {
        CarRacing carRacing = new CarRacing(carCount, tryCount);
        while (!carRacing.isComplete()) {
            carRacing.race();
        }
        assertThat(carRacing.isComplete()).isTrue();
        assertThat(carRacing.getCarCount()).isEqualTo(0);
        assertThat(carRacing.getRacingCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동거리 랜덤 범위 확인")
    void getRandomDistance() {
        CarRacing racing = new CarRacing(1, 1);
        for (int i = 0; i < 10; i++) {
            int distance = racing.getRandomDistance();
            assertThat(distance).isBetween(CarRacingProperty.MIN_RANDOM_DISTANCE, CarRacingProperty.MAX_RANDOM_DISTANCE);
        }
    }
}
