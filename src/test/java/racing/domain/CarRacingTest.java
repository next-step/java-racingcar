package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    void 정상적인_입력값_테스트() {
        CarRacing carRacing = new CarRacing("a,b,c", 5);
        while (!carRacing.isComplete()) {
            carRacing.race();
        }

        assertThat(carRacing.isComplete()).isTrue();
        assertThat(carRacing.getRacingCount()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5, -10})
    void 숫자_0_이하의_시도_횟수_입력(int tryCount) {
        assertThatThrownBy(() -> new CarRacing("a,b,c", tryCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_완료_후_정상적으로_우승자_한_명_이상_체크() {
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
    void 레이스가_종료되기_전에_우승자_가져올_경우() {
        // given
        String[] names = {"pobi","crong","honux"};
        CarRacing racing = new CarRacing(String.join(",", names), 5);

        // when
        racing.race();

        // then
        assertThatThrownBy(racing::getWinners).isInstanceOf(IllegalStateException.class);
    }
}
