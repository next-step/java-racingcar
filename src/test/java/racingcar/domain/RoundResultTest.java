package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RoundResultTest {

    @ParameterizedTest(name = "입력값: {0}")
    @NullAndEmptySource
    void 비어있는_스냅샷_목록으로_생성_시_예외발생(List<CarSnapshot> input) {
        assertThatThrownBy(() -> new RoundResult(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("스냅샷 목록은 비어있을 수 없습니다.");
    }

    @Test
    void findLeaders_선두_자동차_목록을_반환한다() {
        CarSnapshot apple = new CarSnapshot("apple", 3);
        CarSnapshot banana = new CarSnapshot("banana", 5);
        CarSnapshot orange = new CarSnapshot("orange", 5);
        RoundResult result = new RoundResult(List.of(apple, banana, orange));

        List<String> leaders = result.findLeaders();

        assertThat(leaders).containsExactlyInAnyOrder("banana", "orange").hasSize(2);
    }
}
