import domain.racingcar.dto.FixedFalseMovingStrategy;
import domain.racingcar.dto.FixedTrueMovingStrategy;
import domain.racingcar.dto.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarTest {
    private final String TEST_NAME1 = "test1";
    private final String TEST_NAME2 = "test2";
    private RacingCar test1;
    private RacingCar test2;

    @BeforeEach
    public void init() {
        test1 = new RacingCar(0, TEST_NAME1);
        test2 = new RacingCar(0, TEST_NAME2);
    }

    @Test
    public void 자동차_이름_5자초과_테스트() {
        assertThatThrownBy(
                () -> new RacingCar(0, "invalid name")).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("이름은 5자를 넘길 수 없습니다.");
    }

    @Test
    public void 자동차_전진_멈춤_테스트() {
        int go = 1;
        int stop = 0;

        assertAll(
                () -> assertThat(test1.move(new FixedTrueMovingStrategy())).isEqualTo(go),
                () -> assertThat(test2.move(new FixedFalseMovingStrategy())).isEqualTo(stop)
        );
    }
}