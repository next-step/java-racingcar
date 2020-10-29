package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * <pre>
 * * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 * </pre>
 */
public class CarRacingTest {

    @Test
    @DisplayName("자동차 경주가 시작될 때 경주 정보가 없으면 예외를 발생시킨다")
    void errorWhenEmptyRacingInfo() {
        assertThatExceptionOfType(IllegalStateException.class) //
                .isThrownBy(createRacing(0, 0)::start);
    }

    @Test
    @DisplayName("자동차 경주를 실행하면 예외가 발생하지 않는다")
    void startRacing() {
        assertThatCode(createRacing(1, 1)::start).doesNotThrowAnyException();
    }

    private CarRacing createRacing(int cars, int steps) {
        return new CarRacing(new StaticInfoProvider(cars, steps));
    }

    private static class CarRacing {

        private int cars;
        private int steps;

        public CarRacing(RacingInfoProvider racingInfoProvider) {
            cars = racingInfoProvider.countCars();
            steps = racingInfoProvider.countSteps();
        }

        public void start() {
            if (cars == 0 || steps == 0)
                throw new IllegalStateException("레이싱 정보가 존재하지 않습니다.");
        }
    }

    private static class StaticInfoProvider implements RacingInfoProvider {
        private final int cars;
        private final int steps;

        public StaticInfoProvider(int cars, int steps) {
            this.cars = cars;
            this.steps = steps;
        }

        @Override
        public int countCars() {
            return cars;
        }

        @Override
        public int countSteps() {
            return steps;
        }
    }

    private interface RacingInfoProvider {
        int countCars();

        int countSteps();
    }
}
