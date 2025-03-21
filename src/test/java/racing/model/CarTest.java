package racing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.Car;

public class CarTest {

    @ParameterizedTest()
    @CsvSource(value = {"pobi,crong,honux:3", "A,B:2"}, delimiter = ':')
    void 차이름으로_차_생성(String inputText, int expectedCarSize) {
        List<Car> cars = Car.createCars(inputText);
        assertThat(cars.size()).isEqualTo(expectedCarSize);
        assertThat(cars.get(0).getName()).isEqualTo(inputText.split(",")[0]);
    }

    @Test
    void 다섯자넘는_이름_에러() {
        assertThatThrownBy(() -> Car.of("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = " 전진:{0}, 위치:{1}")
    @CsvSource(value = {"false:1", "true:2"}, delimiter = ':')
    void 행동시_전진여부_결과(boolean canProgress, int expectedPosition) {
        Car car = Car.of("name");
        assertThat(car.move(canProgress)).isEqualTo(expectedPosition);
    }


}
