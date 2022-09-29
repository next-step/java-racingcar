import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private final String TEST_NAME1 = "test1";
    private final String TEST_NAME2 = "test2";
    private final String TEST_NAME3 = "test3";
    private RacingCar test1;
    private RacingCar test2;
    private RacingCar test3;

    @Test
    @BeforeEach
    public void init() {
        test1 = new RacingCar(0, TEST_NAME1);
        test2 = new RacingCar(0, TEST_NAME2);
        test3 = new RacingCar(0, TEST_NAME3);
    }

    @Test
    public void 자동차_이름_5자초과() {
        assertThatThrownBy(
                () -> new RacingCar(0, "invalid name")).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("이름은 5자를 넘길 수 없습니다.");
    }

    @Test
    public void 전진() {
        int expectedFirstStep = 1;
        int expectedSecondStep = 2;

        assertThat(test1.move(4)).isEqualTo(expectedFirstStep);
        assertThat(test1.move(9)).isEqualTo(expectedSecondStep);
    }

    @Test
    public void 멈춤() {

        int expectedFirstStep = 0;
        int expectedSecondStep = 0;

        assertThat(test2.move(0)).isEqualTo(expectedFirstStep);
        assertThat(test2.move(3)).isEqualTo(expectedSecondStep);
    }

    @Test
    public void 속도() {
        assertThat(test3.speedOf()).isBetween(0, 9);
    }
}