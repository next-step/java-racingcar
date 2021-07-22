package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.calculator.Common.toInt;

class CarTest {

    @Test
    void 차량기본생성테스트() {
        Car car = Car.createCar();
        System.out.println("car = " + car.getDistance().getMove());
        assertThat(car.getDistance().getMove()).isEqualTo(0);
    }

    @DisplayName("특정거리 만큼 주행한 차 객체를 여러건 생성하여 건마다 검증하는 테스트")
    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3","4,4","5,5"})
    void 차생성및거리입력테스트(String input, String expected) {

        Car car = Car.createCar();

        for(int i =0; i < toInt(input); i++){
            car.getDistance().move();
        }

        assertThat(car.getDistance().getMove()).isEqualTo(toInt(expected));
    }

}