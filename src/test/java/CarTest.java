import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자 초과면 false 를 반환한다")
    void isValidTooLong() {
        //given
        char[] array = new char[5 + 1];
        Arrays.fill(array, 'a');
        String carName = new String(array);
        Car car = new Car(carName);

        //when
        boolean result = car.isValid();

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하면 true 를 반환한다")
    void isValid() {
        //given
        char[] array = new char[5];
        Arrays.fill(array, 'a');
        String carName = new String(array);
        Car car = new Car(carName);

        //when
        boolean result = car.isValid();

        //then
        assertThat(result).isTrue();
    }
}