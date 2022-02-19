import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName("랜덤값이 4 미만이면 움직이지 않는다")
    void stopMoveForSmallInt() {
        //given
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(3);
        Car car = new Car("a");
        int initialPosition = car.getPosition();

        //when
        car.moveRandom(randomNumberMock);
        int afterPosition = car.getPosition();

        //then
        assertThat(afterPosition).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("랜덤값이 4 이상이면 움직인다")
    void moveForBigInt() {
        //given
        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(4);
        Car car = new Car("a");
        int initialPosition = car.getPosition();

        //when
        car.moveRandom(randomNumberMock);
        int afterPosition = car.getPosition();

        //then
        assertThat(afterPosition).isEqualTo(initialPosition + 1);
    }
}