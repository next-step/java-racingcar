package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;
import step3.model.RandomMovingStrategy;


import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        IntStream.range(0, tryNumber).forEach(value -> car.moveForward());
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
        IntStream.range(0, tryNumber).forEach(value -> car.moveForward());
        //then
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("Car객체가 생성 될때 이름의 크기가 5자 이상일 경우 IllegalArgumentException이 발생하는지 확인한다.")
    void nameFiveCharactersExcessTest()
    {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car("abcdefgh", ()-> true));
    }
}
