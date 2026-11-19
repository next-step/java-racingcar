package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.*;
import racingcar.util.RandomGenerator;
import racingcar.view.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    public static final int MOVE_THRESHOLD = 4;

    @Test
    void 랜덤_값이_4이상이면_자동차의_위치가_1_증가한다() {
        Car car = new Car("dumy");
        RandomMoveStrategy strategy = new RandomMoveStrategy(new FixedRandomGenerator(MOVE_THRESHOLD));

        // when
        car.move(strategy);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값이_4미만이면_자동차가_움직이지_않는다() {
        // given: 항상 3을 반환하는 테스트용 RandomGenerator
        Car car = new Car();
        RandomMoveStrategy strategy = new RandomMoveStrategy(new FixedRandomGenerator(MOVE_THRESHOLD - 1));

        // when
        car.move(strategy);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }



    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void 자동차_개수를_입력하면_개수에_맞는_자동차가_생성된다(int carCount) {
        Cars cars = Cars.create(carCount);
        assertThat(cars.getCars()).hasSize(carCount);
    }



    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 시도_횟수가_0_또는_음수이면_IllegalArgumentException_예외가_발생한다(int attemptCount) {
        assertThatThrownBy(() ->
                RacingGame.from(Cars.create(1), attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @ParameterizedTest
    @ValueSource(strings = {";", ":"})
    void 시도_횟수가_문자이면_IllegalArgumentException_예외가_발생한다(String attemptCount) {
        assertThatThrownBy(() -> InputValidator.validateNumber(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }




    @ParameterizedTest
    @ValueSource(strings = {";", ":"})
    void 자동차_개수가_문자이면_IllegalArgumentException_예외가_발생한다(String carCount) {
        assertThatThrownBy(() ->
                InputValidator.validateNumber(carCount))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 자동차_개수가_0_또는_음수이면_IllegalArgumentExceptino_예외가_발생한다(int carCount) {
        assertThatThrownBy(() -> Cars.create(carCount))
                .isInstanceOf(IllegalArgumentException.class);
    }





    private static class FixedRandomGenerator extends RandomGenerator {

        private final int fixedNumber;

        FixedRandomGenerator(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int generateNumber(int bound) {
            return fixedNumber;
        }
    }
}