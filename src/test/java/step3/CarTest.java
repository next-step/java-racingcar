package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        this.car = new Car();
    }

    @DisplayName("자동차 이동  테스트 - 예외 발생 테스트")
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
    public void test2(int value, boolean expected) {
        car.move(value);
        assertThat(car.getLocation() == 1)
                .isEqualTo(expected);
    }

}
