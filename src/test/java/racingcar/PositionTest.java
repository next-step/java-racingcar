package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {

    @ParameterizedTest
    @DisplayName("값이 정상적인 경우")
    @ValueSource(ints = {3,5,7})
    void create(int location) {
        Position position = Position.create(location);
        assertThat(position).isEqualTo(Position.create(location));
    }

    @ParameterizedTest
    @DisplayName("값이 0보다 작은 경우 에러 발생 검증")
    @ValueSource(ints = {-1, -2, -3, -4})
    void createException2(int location) {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.create(location));
    }

}
