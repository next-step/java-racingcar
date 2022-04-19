package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputCars;
import racingcar.model.Car;
import racingcar.model.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("InputCars DTO 테스트")
public class InputCarsTest {

    public static final InputCars TEST_INPUT_CARS = InputCars.fromCarsInfo("test1");

    @Test
    @DisplayName("입력받은 CarsInfo 가 null 이면 NullPointerException 이 발생한다.")
    void inputCarsInfoNullTest() {
        Assertions.assertThatThrownBy(() -> InputCars.fromCarsInfo(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("is null");
    }

    @Test
    @DisplayName("carName stream 변환 테스트")
    void inputCarsStreamTest() {
        // given
        String[] carNames = "test,test1".trim().split(",");

        // when
        List<Car> cars = Arrays.stream(carNames)
                .map(name -> new Car(CarName.from(name.trim())))
                .collect(Collectors.toList());

        // then
        assertThat(cars.get(0).name()).isEqualTo(CarName.from("test"));
        assertThat(cars.get(1).name()).isEqualTo(CarName.from("test1"));
    }
}
