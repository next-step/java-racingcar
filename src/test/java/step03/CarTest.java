package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step03.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:56 오후
 */
class CarTest {


    @ParameterizedTest
    @ValueSource(ints = {4, 4, 6})
    @DisplayName("Car 이동 테스트")
    public void moveTest(int moveCount) {
        final Car car = new Car();
        car.AdvanceOneSpace(moveCount);
        assertThat(car.getMoveCount()).isEqualTo(1);

    @Test
    @DisplayName("Car 초기화 테스트")
    public void test() {

        Car car = new Car();
        Map<Car, Integer> carIntegerMap1 = car.initCar(3);
        assertEquals(carIntegerMap1.size(), 3);

        Map<Car, Integer> carIntegerMap2 = car.initCar(4);
        assertEquals(carIntegerMap2.size(), 7);

        Map<Car, Integer> carIntegerMap3 = car.initCar(5);
        assertEquals(carIntegerMap3.size(), 12);

        Map<Car, Integer> carIntegerMap4 = car.initCar(6);
        assertEquals(carIntegerMap4.size(), 18);


    }
}