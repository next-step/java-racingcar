package javaracingcar;


import javaracingcar.controller.JavaRacingCar;
import javaracingcar.entity.RacingCar;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaRacingCarTest {

    @Test
    void javaRacingCar_Random_범위_0에서_9사이인지() {
        JavaRacingCar racingCar = new JavaRacingCar(3, 5);

        int result = racingCar.random();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    void javaRacingCar_차대수_negative_음수() {

        assertThatThrownBy(() -> new JavaRacingCar(-3, 5)).isInstanceOf(RuntimeException.class);

    }

    @Test
    void javaRacingCar_시도_횟수_negative_음수() {

        assertThatThrownBy(() -> new JavaRacingCar(3, -5)).isInstanceOf(RuntimeException.class);

    }

    @Test
    void javaRacingCar_차대수_입력시_리스트_size() {
        JavaRacingCar racingCar = new JavaRacingCar(3, 5);

        assertThat(racingCar.cars()).hasSize(3);
    }

    @Test
    void javaRacingCar_시도_횟수() {
        JavaRacingCar racingCar = new JavaRacingCar(3, 5);

        assertThat(racingCar.tryCount()).isEqualTo(5);
    }

    @Test
    void javaRacingCar_시작_후_전진_횟수() {
        JavaRacingCar racingCar = new JavaRacingCar(1, 10);

        RacingCar result = racingCar.cars().get(0);

        assertThat(result.moveCount()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(10);
    }


}
