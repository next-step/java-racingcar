package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("위치 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 5, 99})
    void 위치_정상(int param) {
        assertThat(new Position(param)).isEqualTo(new Position(param));
    }

    @DisplayName("위치 이동 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1, 5, 99})
    void 위치_이동(int param) {
        Position position = new Position(param);
        position.move();
        assertThat(position).isEqualTo(new Position(param + 1));
    }
}
