package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {
    private RacingCar racingCar = new RacingCar();

    @Test
    void seperatorTest(){
        String inputStr = "pobi,crong,honux";
        String[] names = racingCar.seperator(inputStr);
        Assertions.assertArrayEquals(names, new String[]{"pobi","crong","honux"});
    }
    @Test
    void createCarTest(){
        String inputStr = "pobi";
        Car car = racingCar.createCar(inputStr);
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void checkMaximumTest(){
        String inputStr = "aaaaaa";
        assertThatThrownBy(()->racingCar.createCar(inputStr))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void moveCar(){
        String inputStr = "pobi";
        Car car = racingCar.createCar(inputStr);
        racingCar.move(car);
        assertThat(car.getPosition()).isEqualTo(2);
    }


}
