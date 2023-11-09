package test.racing;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    @DisplayName("숫자 4이상일때")
    @ParameterizedTest
    @ValueSource(booleans = {true})
    public void 숫자4이상(Boolean bool){
        Car car = new Car();

        car.moveCar(bool);

        assertThat(1).isEqualTo(car.getMoveCount());
    }

    @DisplayName("숫자 4미만일때")
    @ParameterizedTest
    @ValueSource(booleans = {false})
    public void 숫자4미만(Boolean bool){
        Car car = new Car();
        car.moveCar(bool);
        assertThat(0).isEqualTo(car.getMoveCount());
    }

    @DisplayName("랜덤값")
    @ParameterizedTest
    @ValueSource(ints = {10})
    public void 랜덤값(int number){

        assertThat(number).isGreaterThan(new Random().nextInt(10));
    }

    @DisplayName("자동차 이름 5글자 초과일때")
    @Test
    public void 자동차생성_이름5글자초과() {
        List<String> list = new ArrayList<>();
        list.add("123456");

        assertThatThrownBy(() -> new Cars().makeCarList(list)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 이름 5글자 이하일때")
    @Test
    public void 자동차생성_이름5글자이하() {
        List<String> list = new ArrayList<>();
        list.add("12345");

        assertThatThrownBy(() -> new Cars().makeCarList(list)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("우승자 구하는 테스트")
    @Test
    public void 우승자_테스트(){

        Cars cars = new Cars();

        List<String> carList = new ArrayList<>();
        carList.add("pobi");
        carList.add("test");
        carList.add("java");

        cars.makeCarList(carList);

        cars.getCar(0).moveCar(false);
        cars.getCar(1).moveCar(false);
        cars.getCar(2).moveCar(true);

        String result = cars.findWinner();

        System.out.println(result);

    }
}
