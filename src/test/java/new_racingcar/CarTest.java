package new_racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car 테스트")
class CarTest {

    // TODO : 자동차는 4 이상일 때 이동
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    @DisplayName("랜덤값 4 이상 자동차 이동거리 1 확인")
    public void carMoveOneTtest(int randomValue) throws Exception {
        //given
        Car car = new Car(MoveOneStrategy.INSTANCE);
        //when
        car.move(randomValue);
        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }


    // TODO : 자동차는 3 이하일때 움직임 없음
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("랜덤값 3 이하 자동차 이동거리 0 확인")
    public void carMoveZeroTest(int randomValue) throws Exception {
        //given
        Car car = new Car(MoveOneStrategy.INSTANCE);
        //when
        car.move(randomValue);
        //then
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("읽기전용 cars 사용 시 에러 확인")
    public void readOnlyCarTest() throws Exception {
        //given
        Cars cars = new Cars(5);
        //when
        List<Car> carList = cars.getUnmodifiableCars();

        //then
        assertThrows(Exception.class, () -> {
            carList.add(new Car(MoveOneStrategy.INSTANCE));
        });
    }
}