package racingcar;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.number_generator.RandomNumberGenerator;
import racingcar.number_generator.SpecificNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    public void 각_자동차에_이름을_부여할_수_있다() throws Exception {
        String name = "chanu";

        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 에러를 던진다")
    public void 자동차_이름이_5자_초과이면_에러를_던진다() throws Exception {
        String name = "failfail";

        ThrowableAssert.ThrowingCallable callable = () -> new Car(name);

        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Car.OVER_MAX_NAME_SIZE_ERROR_STRING);
    }

    @Test
    @DisplayName("차가 전진한다")
    public void 차가_전진한다() throws Exception {
        Car car = new Car("hello");

        car.forward();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("0에서 9 사이의 랜덤한 숫자를 반환한다")
    public void 영에서_9_사이의_랜덤한_숫자를_반환한다() throws Exception {
        RandomNumberGenerator randomGenerator = new RandomNumberGenerator();
        int number = randomGenerator.generate();
        assertThat(number).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("값이 4 이상일 경우 전진한다")
    public void 값이_4_이상일_경우_전진한다(int number) throws Exception {
        Car car = new Car("chan", new SpecificNumberGenerator(number));

        car.progress();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("값이 3 이하일 경우 멈춘다.")
    public void 값이_3_이하일_경우_멈춘다(int number) throws Exception {
        Car car = new Car("chan", new SpecificNumberGenerator(number));

        car.progress();

        assertThat(car.getDistance()).isEqualTo(0);
    }
}
