package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;
import racingcar.domain.exception.InvalidCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 테스트")
public class CarTest {


    @DisplayName("자동차가 움직이면 position이 증가")
    @Test
    public void increasePosition() {
        Car car = Car.ofName("");
        car.move();

        Integer position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("자동차 이름 5자 초과해서 입력")
    @ParameterizedTest
    @CsvSource(value = {"abcdef", "123456"})
    public void setLongerName(String name) {
        assertThatThrownBy(() -> {
            Car.ofName(name);
        }).isInstanceOf(InvalidCarNameLengthException.class)
                .hasMessageContaining("invalid car name length");
    }
}