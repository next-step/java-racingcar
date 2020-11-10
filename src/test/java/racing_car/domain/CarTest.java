package racing_car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing_car.domain.strategy.ForTestStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "True:1",
            "False:0"
    },
            delimiter = ':')
    public void test(boolean isMove, int expected) {
        Car car = new Car("name", new ForTestStrategy(() -> isMove));

        car.move();

        assertThat(car.getLocation()).isEqualTo(expected);
    }

    @DisplayName("자동차 이름 유효성 검사 예외 발생 ")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "aaaaaa"
    })
    public void test2(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name, new ForTestStrategy(() -> true));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동전략 없을때 예외 발생 테스트 ")
    @Test
    public void test3() {
        assertThatThrownBy(() -> {
            Car car = new Car("name", null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
