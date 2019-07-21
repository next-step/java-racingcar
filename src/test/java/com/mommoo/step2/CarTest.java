package com.mommoo.step2;

import com.mommoo.step2.domain.CarMovingConditioner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @DisplayName("객체의 상태 값 호출 테스트")
    @Test
    public void testPropertiesIsValid() {
        String carName = "Mommoo";
        int position = 10;

        Car car = new Car(carName, position);
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차 객체의 다음 포지션 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5,6,7,8,9})
    public void testNextPositionCar(int position) {
        Car car = new Car("Mommoo", position);

        CarMovingConditioner carMovingConditioner = new CarMovingConditioner();

        Car nextPositionCar = car.nextCar(carMovingConditioner);
        int nextPosition = nextPositionCar.getPosition();

        int expectedPosition = carMovingConditioner.isCanMove() ? position + 1 : position;

        assertThat(nextPosition).isEqualTo(expectedPosition);
    }
}
