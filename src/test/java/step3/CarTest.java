package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "-2",
            "10"
    })
    public void test1(int value) {
        assertThatThrownBy(() -> {
                    car.move(value);

                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "0:False",
            "1:False",
            "2:False",
            "3:False",
            "4:False",
            "5:True",
            "6:True",
            "7:True",
            "8:True",
            "9:True",
    }, delimiter = ':')
    public void test3(boolean move, int expected) {
        Car car = new Car("name", new ForTestStrategy(() -> move));
        car.move();
        assertThat(car.getLocation()).isEqualTo(expected);
    }

}
