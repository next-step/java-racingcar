package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Collections.max;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private static Cars createCars() {
        return Cars.fromNames(List.of("john", "tom", "jin"));
    }

    @DisplayName("시도 횟수가 0이거나 음수이면 RuntimeException (0, -1)")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void test_1(int tryCount) {
        assertThatThrownBy(() -> new RacingGame(createCars(), tryCount, new RandomNumberGenerator(10)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("시도 횟수");
    }

    @DisplayName("N회 시도하면 어떤 자동차도 N칸을 넘어 전진하지 않는다. (5회 → 위치 ≤ 5)")
    @Test
    void test_2() {
        RacingGame game = new RacingGame(createCars(), 5, new RandomNumberGenerator(10));
        game.race();
        assertThat(max(game.getPositions())).isLessThanOrEqualTo(5);
    }

    @DisplayName("이미 진행한 레이싱 게임을 다시 진행하면 RuntimeException")
    @Test
    public void test_3() {
        RacingGame game = new RacingGame(createCars(), 5, new RandomNumberGenerator(10));
        game.race();
        assertThatThrownBy(() -> game.race())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이미 완료");
    }

    @DisplayName("N회 시도한 뒤 결과를 꺼내면 라운드별 기록이 N개다. (5회 → 5개)")
    @Test
    public void test_4() {
        RacingGame game = new RacingGame(createCars(), 5, new RandomNumberGenerator(10));
        game.race();
        assertThat(game.getRaceResult()).hasSize(5);
    }

}
