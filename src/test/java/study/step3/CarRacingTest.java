package study.step3;

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
    private CarRacing carRacing;
    private ResultView resultView;
    private Circuit circuit;

    @Test
    @DisplayName("자동차 경주를 실행하면 예외가 발생하지 않는다")
    void startRacing() {
        setUpLapsAndCars(new TestingCar());
        setUpRacing();

        assertThatCode(carRacing::start).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 경주를 시작하면 자동차가 달린다.")
    void carMoved() {
        setUpLapsAndCars(new TestingCar());
        setUpRacing();

        carRacing.start();

        assertThat(theCar().isMoved()).isTrue();
    }

    @Test
    @DisplayName("자동차 경주 시작전엔 자동차가 달리지 않는다.")
    void carNotMoved() {
        setUpLapsAndCars(new TestingCar());
        setUpRacing();

        assertThat(theCar().isMoved()).isFalse();
    }

    private Car theCar() {
        return circuit.getCars().iterator().next();
    }

    @Test
    @DisplayName("자동차 경주는 경주결과를 출력하는 ResultView를 받을 수 있다.")
    void acceptableResultView() {
        setUpLapsAndCars(new TestingCar());
        setUpRacing();

        assertThat(resultView.isCommitted()).isFalse();
    }

    @Test
    @DisplayName("경주를 시작하면 경주결과가 저장되어 있다.")
    void resultViewCommittedAfterStaring() {
        setUpLapsAndCars(new TestingCar());
        setUpRacing();

        carRacing.start();

        assertThat(resultView.isCommitted()).isTrue();
    }

    private void setUpLapsAndCars(Car... cars) {
        this.circuit = new Circuit(new HashSet<>(Arrays.asList(cars)), 1);
    }

    private void setUpRacing() {
        this.resultView = new ResultView();
        this.carRacing = new CarRacing(circuit, resultView);
    }

    static class StaticInfoProvider implements RacingInfoProvider {
        private final int steps;
        private final Set<Car> cars;

        public StaticInfoProvider(int rename, Car... cars) {
            this.steps = rename;
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

    private static class TestingCar implements Car {
        private boolean isMoved;

        @Override
        public boolean isMoved() {
            return isMoved;
        }

        @Override
        public void move() {
            isMoved = true;
        }

        @Override
        public Long getId() {
            return null;
        }
    }

}
