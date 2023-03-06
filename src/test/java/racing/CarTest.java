package racing;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("이름 초과 테스트")
    void vaildNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                            Car car = new Car("llllcas");
                        }
                ).withMessageContaining("5자를 초과");
    }

    @DisplayName("moveOption에 따라 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1"
    })
    void moveTest(final int moveOption, int expect) {
        Car car = new Car("lucas");
        int actaul = car.move(moveOption);
        assertEquals(actaul, expect);
    }

    @Test
    @DisplayName("현재위치 포맷에 따라 잘 나오는지 검증")
    void getPositionFormatTest() {
        Car car = new Car("lucas");
        car.position = 5;

        String actaul = car.getPositionFormat();

        assertThat(actaul).contains("lucas").contains(" : ").contains("--");
        assertThat(actaul).isEqualTo("lucas : -----");
    }
}
