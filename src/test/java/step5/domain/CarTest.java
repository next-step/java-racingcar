package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.util.Constants;
import step5.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @ParameterizedTest
    @DisplayName("입력한 자동차 이름의 길이가 5자 초과 여부 테스트")
    @ValueSource(strings = {"hyundai, renault"})
    void is_valid_car_name(String input) {
        assertThatThrownBy(() -> {
            Car car = new Car(0, input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.NAME_IS_MORE_THAN_FIVE_WORDS);
    }

    @ParameterizedTest
    @DisplayName("입력된 조건에 따라 자동차의 전진 여부 테스트")
    @CsvSource(value = {"3:0", "4:1", "9:1"}, delimiter = ':')
    void move_or_stop(int condition, int expectedPosition) {
        Car car = new Car(0, "car1");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @DisplayName("자동차의 이동거리 출력 테스트")
    @CsvSource(value = {"2,5,3,---"}, delimiter = ',')
    void print(int beforePosition, int condition, int afterPosition, String expectedMark) {
        Car car = new Car(beforePosition, "car2");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(afterPosition);
        assertThat(ResultView.printEachCar(car)).isEqualTo(expectedMark);
    }

}