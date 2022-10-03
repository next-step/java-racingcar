import dto.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private final String TEST_NAME1 = "test1";
    private final String TEST_NAME2 = "test2";
    private final String TEST_NAME3 = "test3";
    private RacingCar test1;
    private RacingCar test2;
    private RacingCar test3;

    @BeforeEach
    public void init() {
        test1 = new RacingCar(0, TEST_NAME1);
        test2 = new RacingCar(0, TEST_NAME2);
        test3 = new RacingCar(0, TEST_NAME3);
    }

    @Test
    public void 자동차_이름_5자초과_테스트() {
        assertThatThrownBy(
                () -> new RacingCar(0, "invalid name")).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("이름은 5자를 넘길 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    public void 자동차_전진_테스트(int input) {
        int expected = 1;
        assertThat(test1.move(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    public void 자동차_멈춤_테스트(int input) {
        int expected = 0;

        assertThat(test2.move(input)).isEqualTo(expected);
    }

    @Test
    public void 자동차_속도_테스트() {
        assertThat(test3.speedOf()).isBetween(0, 9);
    }
}