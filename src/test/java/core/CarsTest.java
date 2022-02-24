package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("이름이 MAX_CAR_NAME_LENGTH 초과인 자동차가 있으면 false 를 반환한다")
    void notValidCarExist() {
        //given
        char[] invalidArray = new char[Car.MAX_CAR_NAME_LENGTH + 1];
        char[] validArray = new char[Car.MAX_CAR_NAME_LENGTH];

        Arrays.fill(invalidArray, 'a');
        Arrays.fill(validArray, 'a');

        String invalidCarName = new String(invalidArray);
        String validCarName = new String(validArray);

        List<String> carNames = Arrays.asList(invalidCarName, validCarName);

        Cars cars = Cars.fromCarNames(carNames);

        //when
        boolean result = cars.isValid();

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("이름이 MAX_CAR_NAME_LENGTH 초과인 자동차가 없으면 true 를 반환한다")
    void allCarValid() {
        //given
        char[] array = new char[Car.MAX_CAR_NAME_LENGTH];
        Arrays.fill(array, 'a');
        String carName = new String(array);

        List<String> carNames = Arrays.asList(carName, carName);

        Cars cars = Cars.fromCarNames(carNames);

        //when
        boolean result = cars.isValid();

        //then
        assertThat(result).isTrue();
    }
}