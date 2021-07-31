package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class CarRacingTest {

    @Test
    @DisplayName("입력한 자동차 수만큼 객체가 생성됐는지 확인한다.")
    void input_car_count() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        int carCount = 3;
        int tryCount = 5;

        //when
        CarRacing carRacing = new CarRacing(carCount, tryCount);

        Method method = carRacing.getClass().getDeclaredMethod("racing");
        method.setAccessible(true);
        List<Car> cars = (List<Car>) method.invoke(carRacing);

        //then
        assertThat(cars.size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource({"3, 5"})
    @DisplayName("racing()을 테스트한다.")
    void doRacingStart(int carCount, int tryCount) {
        assertThatCode(() -> {
            CarRacing carRacing = new CarRacing(carCount, tryCount);
            carRacing.racingStart();
        }).doesNotThrowAnyException();
    }
}