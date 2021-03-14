package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.domain.Position;

class PositionTest {

    @ParameterizedTest
    @CsvSource({"3, ---"})
    @DisplayName("자동차의 위치를 표시할 수 있다.")
    void canDisplayCarPosition(int position, String displayPosition) {
        Assertions.assertThat(new Position(position).toString()).isEqualTo(displayPosition);
    }
}