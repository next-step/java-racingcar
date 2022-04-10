package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringToCarTransformerTest {

    @Test
    @DisplayName("문자열 리스트를 통해 자동차 리스트를 반환한다")
    void convertToCarListTest() {
        //given
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");

        //when
        List<Car> cars = StringToCarTransformer.convertToCarList(carNames);

        //then
        assertAll(
                () -> assertThat(cars.get(0).getCarNameValue()).isEqualTo("자동차1"),
                () -> assertThat(cars.get(1).getCarNameValue()).isEqualTo("자동차2"),
                () -> assertThat(cars.get(2).getCarNameValue()).isEqualTo("자동차3")
        );
    }

}