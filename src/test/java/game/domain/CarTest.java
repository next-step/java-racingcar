package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2", "7:2", "9:2", "0:1", "3:1"}, delimiter = ':')
    @DisplayName("0~9 사이의 숫자가 넘어온다")
    void normal_number(int number, int result) {
        car.move(number);
        int distance = car.getDistance();
        assertThat(distance).isEqualTo(result);
    }

    @Test
    @DisplayName("9보다 큰 숫자가 넘어온다")
    void larger_than_max_number() {
        final int MAX_NUMBER = 9;
        assertThatThrownBy(() -> {
            car.move(MAX_NUMBER + 1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 넘어온다")
    void negative() {
        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름이 null 또는 empty")
    void name_is_null_or_empty() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름이 5글자를 초과")
    void name_is_larger_than_5() {
        assertThatThrownBy(() -> {
            new Car("123456");
        }).isInstanceOf(RuntimeException.class);
    }
}
