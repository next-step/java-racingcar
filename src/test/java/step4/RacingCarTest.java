package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("test racing car")
    public void test(){
        //given
        RacingCar racingCar = new RacingCar();

        Car car1 = new Car("car1");
        car1.run(4);
        car1.run(4);

        Car car2 = new Car("car2");
        car2.run(0);
        car2.run(5);

        Car car3 = new Car("car3");
        car3.run(6);
        car3.run(6);

        //when
        //then
        assertThat(racingCar.getWinner(Arrays.asList(car1, car2, car3))).isEqualTo("car1,car3");
    }

    @Test
    @DisplayName("test racing car : input")
    public void test2(){
        //given
        RacingCar racingCar = new RacingCar();

        //when
        racingCar.run("pobi,crong,honux", 5);

        assertThat(racingCar.getCarListSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("test racing car : input exceeded max name size")
    public void test3(){
        //given
        RacingCar racingCar = new RacingCar();

        //when
        assertThatIllegalArgumentException().isThrownBy(()-> racingCar.run("pobiii,crong,honux", 5));
    }
}