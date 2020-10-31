package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 테스트")
public class CarTest {
    Car car = new Car();

    @DisplayName("자동차가 입력 받은 행운의 숫자가 4이상일 경우에 움직임")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true",
            "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    public void moveCar(Integer luckyNumber, boolean expectedResult) {
        boolean result = car.move(luckyNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("자동차가 받는 행운의 숫자는 0과 9사이여야 함")
    @ParameterizedTest
    @CsvSource(value = {"-1", "10"})
    public void moveCarWithTooLowLuck(Integer number) {
        assertThatThrownBy(() -> {
            car.move(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid luck");
    }

    @DisplayName("자동차가 움직이면 position이 증가")
    @Test
    public void increasePosition() {
        car.move(9);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 움직이지 않으면 position이 변화 없음")
    @Test
    public void stopPosition() {
        car.move(1);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}