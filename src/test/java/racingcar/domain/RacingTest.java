package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingTest {

    private String carNames;
    private Round round;

    @BeforeEach
    void setUp() {
        carNames = "name1,name2";
        round = Round.of(1);
    }

    @DisplayName("Racing 생성")
    @Test
    void create() {
        assertThatCode(() -> Racing.of(Cars.of(carNames), round))
                .doesNotThrowAnyException();
    }

    @DisplayName("경주 실패: 전략이 null 인 경우")
    @Test
    void run() {
        Cars cars = Cars.of(carNames);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Racing.of(cars, round).run(null));
    }
}
