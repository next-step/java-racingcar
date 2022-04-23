package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 10})
    void 위치_객체_생성시_위치_변수가_잘_넘어오는지_확인(int number) {
        Position position = new Position(number);

        assertThat(position.getPosition()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3, -4, -10})
    void 위치_객체_생성시_0이하의_위치일_경우_에러_발생(int number) {
        String errorMessage = "위치는 0이상 이여야 됩니다.";

        assertThatThrownBy(() -> new Position(number))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(errorMessage);
    }

}
