package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.RandomNumber;
import racingcar.service.ValidationCheck;
import racingcar.domain.Car;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @Test
    @DisplayName("입력값이 null이나 빈문자가 들어오면 오류가 나는지 테스트")
    public void ValidationCheck_null_빈문자() {
        assertThatThrownBy(() -> ValidationCheck.checkInputCarCount(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 음수값이 들어오면 오류가 나는지 테스트")
    public void ValidationCheck_음수() {
        assertThatThrownBy(() -> ValidationCheck.checkInputCarCount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 문자가 들어오면 오류가 나는지 테스트")
    public void ValidationCheck_문자() {
        String input = "a";
        assertThatThrownBy(() -> ValidationCheck.checkInputCarCount(Integer.parseInt(input))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤값이 0~9 값으로 생성되는지 확인한다.")
    public void RandomNumber() {
        int randomNumber = RandomNumber.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThan(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false"}, delimiter = ':')
    void isMovable_전진테스트(int number, boolean result) {
        Car car = new Car();
        boolean isMovable = car.isMovable(number);
        assertThat(isMovable).isEqualTo(result);
    }
}