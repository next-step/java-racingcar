package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    @DisplayName("정상적인 입력값으로 정상적으로 수행하고 초기화하는지 테스트")
    public void should_success_when_normalInput() {
        CarRacing carRacing = new CarRacing("a,b,c", 5);
        while (!carRacing.isComplete()) {
            carRacing.race();
        }

        assertThat(carRacing.isComplete()).isTrue();
        assertThat(carRacing.getRacingCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5, -10})
    @DisplayName("0 이하의 시도 횟수 입력값")
    public void race_invalidTryInput_exceptThrown(int tryCount) {
        assertThatThrownBy(() -> new CarRacing("a,b,c", tryCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동거리 랜덤 범위 확인")
    void getRandomDistance() {
        CarRacing racing = new CarRacing("a,b,c", 1);
        for (int i = 0; i < 10; i++) {
            int distance = racing.getRandomDistance();
            assertThat(distance).isBetween(CarRacingProperty.MIN_RANDOM_DISTANCE, CarRacingProperty.MAX_RANDOM_DISTANCE);
        }
    }

    @Test
    @DisplayName("경주 완료 후 정상적으로 우승자 한 명 이상 체크")
    void completeRace_normalInput_returnWinner() {
        // given
        CarRacing racing = new CarRacing("pobi,crong,honux", 3);

        // when
        while (!racing.isComplete()) {
            racing.race();
        }

        // then
        String[] winners = racing.getWinners();
        assertThat(winners.length).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("레이스가 종료되기 전에 우승자 가져올 경우")
    void getWinners_notCompletedRace_exceptThrown() {
        // given
        String[] names = {"pobi","crong","honux"};
        CarRacing racing = new CarRacing(String.join(",", names), 5);

        // when
        racing.race();

        // then
        assertThatThrownBy(racing::getWinners).isInstanceOf(IllegalStateException.class);
    }
}
