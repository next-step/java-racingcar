package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @ParameterizedTest
    @DisplayName("전진 조건에서 자동차가 전진하는지 테스트")
    @ValueSource(ints = {4,5,6,7,8,9})
    void move_forward(int condition) {
        Car car = new Car(0);
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("전진 조건이 아닌 경우 자동차가 멈추는지 테스트")
    @ValueSource(ints = {0,1,2,3})
    void stop(int condition) {
        Car car = new Car(0);
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
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