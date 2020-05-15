package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingTest {

    @DisplayName("Racing 생성")
    @Test
    void create() {
        String[] carNames = new String[]{"name1", "name2"};

        assertThatCode(() -> Racing.of(Cars.of(carNames), Round.of(1)))
                .doesNotThrowAnyException();
    }

    @DisplayName("경주 실패: 전략이 null 인 경우")
    @Test
    void run() {
        String[] carNames = new String[]{"name1", "name2"};
        Cars cars = Cars.of(carNames);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Racing.of(cars, Round.of(1)).run(null));
    }
}
