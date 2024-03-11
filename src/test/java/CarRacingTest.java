import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarRacingTest {
    @Test
    @DisplayName("자동차 객체 생성 시 위치값은 0이다")
    void carObjectInitialValue() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상이면 전진한다")
    @ValueSource(ints = {4, 5})
    void carMoveForward(int number) {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4미만이면 전진하지 않는다")
    @ValueSource(ints = {2, 3})
    void carNotMoveForward(int number) {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("InputVO는 0이상의 정수만 입력받을 수 있다")
    @CsvSource(value = {"-1: 3"}, delimiter = ':')
    void inputVONotValid(int carNumber, int tryNumber) {
        assertThatThrownBy(() -> {
            InputVO inputVO = new InputVO(carNumber, tryNumber);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0이상의 정수만 입력 가능합니다.");
    }

}
