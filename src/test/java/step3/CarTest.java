package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;


import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest
{
    @Test
    @DisplayName("Car객체가 움직일 수 있을 때 position의 값이 증가되는지 확인한다.")
    void moveTest()
    {

        //given
        Car car = new Car(() -> true);
        int tryNumber = 5;
        //when
        IntStream.range(0, tryNumber).forEach(value -> car.moving());
        //then
        assertThat(car.getPosition()).isEqualTo(tryNumber);
    }

    @Test
    @DisplayName("Car객체가 움직일 수 없을 때 position의 값이 변경이 없는지 확인한다.")
    void stopTest()
    {

        //given
        Car car = new Car(() -> false);
        int tryNumber = 5;
        //when
        IntStream.range(0, tryNumber).forEach(value -> car.moving());
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
