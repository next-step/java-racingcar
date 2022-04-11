package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarLocationResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarLocationResultConverterTest {

    @Test
    @DisplayName("사용자별 현재 위치를 변경하는 객체를 반환한다")
    void convertIntoCarLocationResultTest() {
        //given
        List<Car> cars = List.of(Car.from("자동차1"), Car.from("자동차2"), Car.from("자동차3"));

        //when
        List<CarLocationResult> carLocationResults = CarLocationResultConverter.convertIntoCarLocationResult(cars);

        //then
        assertAll(
                () -> assertThat(carLocationResults.get(0).getCarName()).isEqualTo("자동차1"),
                () -> assertThat(carLocationResults.get(1).getCarName()).isEqualTo("자동차2"),
                () -> assertThat(carLocationResults.get(2).getCarName()).isEqualTo("자동차3")
        );
    }

}