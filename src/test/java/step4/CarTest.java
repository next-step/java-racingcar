package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @DisplayName("입력된 조건에 따라 자동차의 전진 여부 테스트")
    @CsvSource(value = {"3:0", "4:1", "9:1"}, delimiter = ':')
    void move_or_stop(int condition, int expectedPosition) {
        Car car = new Car(0);
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @DisplayName("자동차의 이동거리 출력 테스트")
    @CsvSource(value = {"2,5,3,---"}, delimiter = ',')
    void print(int beforePosition, int condition, int afterPosition, String expectedMark) {
        Car car = new Car(beforePosition);
        ResultView resultView = new ResultView();
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(afterPosition);
        assertThat(resultView.printEachCar(car)).isEqualTo(expectedMark);
    }

}