package study.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static study.racing.common.Common.toInt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @ParameterizedTest
    @CsvSource(value = {"1,0","2,0","4,1","9,1"})
    void 선택된랜덤값이4이상인지체크테스트(int input, int expected) {
        Car car = new Car();
        car.moveTheCar(input);
        assertThat(car.getDistance().getMoveDistance()).isEqualTo(expected);
    }

    @DisplayName("차객체 생성시 이름주입 테스트")
    @ParameterizedTest
    @CsvSource(value = {"test1,test1","test!,test!","12345,12345","가나다라마,가나다라마"})
    void 차이름입력테스트(String input, String expected) {
        Car car = Car.createCar(input);
        assertThat(car.getName().getCarName()).isEqualTo(expected);
    }

    @DisplayName("차를 생성하고 이동시키는 조건을 부여할때 정상적으로 이동되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"test1,6,0","test1,5,0"})
    void 차이동거리최대값테스트(String input, int move, int target) {
        Car car = Car.createCar(input);
        car.moveTheCar(move);

        int max = car.maxDistance(car);

        assertThat(max).isGreaterThan(target);
    }
}