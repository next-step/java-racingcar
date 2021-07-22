package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.racing.common.Common.toInt;

class CarTest {

    @Test
    void 차량기본생성테스트() {
        Car car = Car.createCar();
        assertThat(car.getDistance().getMoveDistance()).isEqualTo(0);
    }

    @DisplayName("특정거리 만큼 주행한 차 객체를 여러건 생성하여 건마다 검증하는 테스트")
    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3","4,4","5,5"})
    void 차생성및거리입력테스트(String input, String expected) {

        Car car = Car.createCar();

        for(int i =0; i < toInt(input); i++){
            car.getDistance().move();
        }

        assertThat(car.getDistance().getMoveDistance()).isEqualTo(toInt(expected));
    }

    @DisplayName("파라메터값이 4이상인지 체크 테스트")
    @Test
    void 선택된랜덤값이4이상인지체크테스트() {
        Car car = new Car();
        //car.moveTheCar(car);
    }
}