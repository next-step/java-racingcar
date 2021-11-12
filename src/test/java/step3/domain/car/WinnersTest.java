package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnersTest {

    @DisplayName("null 이나 빈 리스트로 생성하면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] List<Car>: {0}")
    @NullAndEmptySource
    void createEmptySource(List<Car> cars) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Winners(cars))
                .withMessage(Winners.WINNER_SIZE_ERROR_MESSAGE);
    }

}
