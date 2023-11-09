package racing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @CsvSource({"0, false", "1, false", "2, false", "3, false", "4, true", "5, true", "6, true",
        "7, true", "8, true", "9, true"})
    @ParameterizedTest(name = "자동차 전진 테스트: input = {0}, 전진 성공 = {1}")
    void move_car(int number, boolean expected) {
        // given
        Car car = new Car("test", 0);

        // whern
        int prevPosition = car.position().position();
        car.move(number);

        // then
        assertThat(car.position().equals(new Position(prevPosition + 1))).isEqualTo(expected);
    }

    @DisplayName("자동차명 길이 제한 테스트")
    @Test()
    void car_name_length() {
        // given
        String name = "5섯_글자_초과";

        // when, then
        assertThatThrownBy(() -> new Car(name, 0))
            .isInstanceOf(ValidationException.class)
            .hasMessageContaining("name can't over 5 letters");
    }

    @DisplayName("우승자 확인 테스트")
    @Test
    void winner() {
        // given
        Car car1 = new Car("test1", 0);
        Car car2 = new Car("test2", 1);
        Car car3 = new Car("test3", 2);

        // when, then

    }
}
