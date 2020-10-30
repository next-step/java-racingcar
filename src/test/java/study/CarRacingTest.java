package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("자동차 경주를 시작하면 자동차가 달린다.")
    void carMoved() {
        Car car = new NormalCar();
        CarRacing racing = new CarRacing(new StaticInfoProvider(1, car));

        racing.start();

        assertThat(car.isMoved()).isTrue();
    }

    @Test
    @DisplayName("자동차 경주 시작전엔 자동차가 달리지 않는다.")
    void carNotMoved() {
        Car car = new NormalCar();
        new CarRacing(new StaticInfoProvider(1, car));

        assertThat(car.isMoved()).isFalse();
    }

    private CarRacing createRacing(int laps, int startingGridCars) {
        Car[] cars = new Car[startingGridCars];
        for (int i = 0; i < startingGridCars; i++) {
            cars[i] = new NormalCar();
        }
        return new CarRacing(new StaticInfoProvider(laps, cars));
    }

    private static class CarRacing {

        private final Set<Car> cars;
        private final int steps;

        public CarRacing(RacingInfoProvider racingInfoProvider) {
            cars = racingInfoProvider.getCars();
            steps = racingInfoProvider.countSteps();
        }

        public void start() {
            if (cars.isEmpty() || steps == 0)
                throw new IllegalStateException("레이싱 정보가 존재하지 않습니다.");

            for (int i = 0; i < steps; i++) {
                move();
            }
        }

        private void move() {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    private static class StaticInfoProvider implements RacingInfoProvider {
        private final int steps;
        private final Set<Car> cars;

        public StaticInfoProvider(int steps, Car... cars) {
            this.steps = steps;
            this.cars = new HashSet<>(Arrays.asList(cars));
        }

        @Override
        public Set<Car> getCars() {
            return cars;
        }

        @Override
        public int countSteps() {
            return steps;
        }
    }

    private interface RacingInfoProvider {
        Set<Car> getCars();

        int countSteps();
    }

    private class NormalCar implements Car {
        private boolean isMoved;
        @Override
        public boolean isMoved() {
            return isMoved;
        }

        @Override
        public void move() {
            isMoved = true;
        }
    }
}
