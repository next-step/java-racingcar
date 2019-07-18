package com.mommoo.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    public void testNextPositionCar() {
        int position = 10;
        Car car = new Car("Mommoo", position);

        Car nextPositionCar = car.nextCar();
        int nextPosition = nextPositionCar.getPosition();

        assertThat(nextPosition).isEqualTo(position+1);
    }
}
