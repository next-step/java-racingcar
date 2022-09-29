package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.rule.move.MoveStrategy;
import racing.rule.move.RandomMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameSetTest {

    @Test
    @DisplayName("게임 설정 - 규칙 설정 확인")
    void 설정규칙_확인() {
        RandomMove randomMove = new RandomMove();
        List<String> carNames = Arrays.asList("car1", "car2");
        GameSet gameSet = new GameSet.GameSetBuilder(
                randomMove, carNames, 3).build();

        assertThat(gameSet.getMoveStrategy()).isEqualTo(randomMove);
        assertThat(gameSet.getCarNames()).isEqualTo(carNames);
        assertThat(gameSet.getNumberOfMove()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 설정 - 이동 규칙 예외 검증")
    void 설정규칙_빌더_이동규칙_예외_검증() {
        assertThatThrownBy(() -> new GameSet.GameSetBuilder(
                null, Arrays.asList("car1", "car2"), 3).build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 설정 - 차량명 예외 검증")
    void 설정규칙_빌더_차량명_예외_검증() {
        assertThatThrownBy(() -> new GameSet.GameSetBuilder(
                new RandomMove(), new ArrayList<String>(), 3).build())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 설정 - 이동 수 예외 검증")
    void 설정규칙_빌더_이동수_예외_검증() {
        assertThatThrownBy(() -> new GameSet.GameSetBuilder(
                new RandomMove(), Arrays.asList("car1", "car2"), -1).build())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
