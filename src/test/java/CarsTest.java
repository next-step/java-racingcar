import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("이름이 5자 초과인 자동차가 있으면 false 를 반환한다")
    void notValidCarExist() {
        //given
        char[] invalidArray = new char[5 + 1];
        char[] validArray = new char[5];

        Arrays.fill(invalidArray, 'a');
        Arrays.fill(validArray, 'a');

        String invalidCarName = new String(invalidArray);
        String validCarName = new String(validArray);

        String[] carNames = {invalidCarName, validCarName};

        Cars cars = Cars.of(carNames);

        //when
        boolean result = cars.isValid();

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("이름이 5자 초과인 자동차가 없으면 true 를 반환한다")
    void allCarValid() {
        //given
        char[] array = new char[5];
        Arrays.fill(array, 'a');
        String carName = new String(array);

        String[] carNames = {carName, carName};

        Cars cars = Cars.of(carNames);

        //when
        boolean result = cars.isValid();

        //then
        assertThat(result).isTrue();
    }
}