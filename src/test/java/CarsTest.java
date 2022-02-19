import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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

    @Test
    @DisplayName("모든 차에 대해 moveRandom 을 1번씩 호출한다")
    void allCarMove() {
        //given
        String[] carNames = {"a", "b"};
        Cars cars = Cars.of(carNames);

        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(anyInt())).thenReturn(4);

        List<Integer> initialPositions =  cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        List<Integer> desiredPositions = initialPositions.stream()
                .map(position -> position + 1)
                .collect(Collectors.toList());

        //when
        cars.moveRandom(randomNumberMock);
        List<Integer> afterPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        //then
        assertThat(afterPositions).isEqualTo(desiredPositions);
    }
}