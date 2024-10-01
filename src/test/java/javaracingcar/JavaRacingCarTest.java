package javaracingcar;


import javaracingcar.entity.RacingCar;
import javaracingcar.entity.RacingCarStepEnum;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaRacingCarTest {

    @Test
    void javaRacingCar_Random_범위_0에서_9사이인지() {
        JavaRacingCar racingCar = new JavaRacingCar();

        int result = racingCar.random();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @Test
    void javaRacingCar_객체_생성_시_step() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThat(racingCar.step()).isEqualTo(RacingCarStepEnum.INIT);
    }

    @Test
    void javaRacingCar_차대수_입력_시_step() {
        JavaRacingCar racingCar = new JavaRacingCar();

        racingCar.requireCarCount(3);

        assertThat(racingCar.step()).isEqualTo(RacingCarStepEnum.CONFIRMED_CAR_COUNT);
    }

    @Test
    void javaRacingCar_시도_횟수_입력_시_step() {
        JavaRacingCar racingCar = new JavaRacingCar();

        racingCar.requireCarCount(3);
        racingCar.requireTryCount(5);

        assertThat(racingCar.step()).isEqualTo(RacingCarStepEnum.CONFIRMED_TRY_COUNT);
    }

    @Test
    void javaRacingCar_차대수_negative_음수() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThatThrownBy(() -> racingCar.requireCarCount(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void javaRacingCar_시도_횟수_negative_음수() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThatThrownBy(() -> racingCar.requireTryCount(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void javaRacingCar_차대수_입력시_리스트_size() {
        JavaRacingCar racingCar = new JavaRacingCar();

        racingCar.requireCarCount(3);

        assertThat(racingCar.cars()).hasSize(3);
    }

    @Test
    void javaRacingCar_시작_후_전진_횟수() {
        JavaRacingCar racingCar = new JavaRacingCar();

        racingCar.requireCarCount(1);
        racingCar.requireTryCount(10);

        RacingCar result = racingCar.start().get(0);

        assertThat(result.moveCount()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(10);
    }

    @Test
    void javaRacingCar_Random_생성_시_시도_횟수() {
        JavaRacingCar racingCar = new JavaRacingCar();

        assertThat(racingCar.tryCount()).isEqualTo(0);
    }

}
