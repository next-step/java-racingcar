package service;

import domain.Car;
import domain.Cars;
import domain.Positions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.util.ReflectionTestUtils;
import util.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingServiceTest {
    private CarRacingService carRacingService;

    @DisplayName("자동차 등록 테스트 - 총 자동차 대수와 각 자동차의 위치 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 100})
    void carRegisterTest(int carCount) {
        carRacingService.registerNewCars(carCount);
        carRacingService =  new CarRacingService(TestMoveStrategy.getInstance(true));
        Cars cars = (Cars) ReflectionTestUtils.getField(carRacingService, "cars");
        List<Car> carList = (List<Car>) ReflectionTestUtils.getField(cars, "cars");
        assertThat(carList).hasSize(carCount);
        carList.forEach(car -> assertThat(car.getPosition().getPosition()).isEqualTo(0));
    }

    @DisplayName("여러 자동차의 주행 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false", "3:true", "5:true", "100:true", "200:false"}, delimiter = ':')
    void carRacingTest(int attemptCount, boolean movable) {
        carRacingService =  new CarRacingService(TestMoveStrategy.getInstance(movable));
        carRacingService.registerNewCars(5);
        List<Positions> positionsList = carRacingService.startRacing(attemptCount);

        int distance = 1;
        for (Positions positions : positionsList) {
            check(positions, movable, distance);
            distance++;
        }
    }

    private void check(Positions positions, boolean movable, int distance) {
        positions.getPositions()
                .forEach(position -> assertThat(position).isEqualTo(movable ? distance : 0));
    }

    static class TestMoveStrategy implements MoveStrategy {
        private static final TestMoveStrategy testMoveStrategy = new TestMoveStrategy();
        private static boolean moveState = false;

        private TestMoveStrategy() {
        }

        public static TestMoveStrategy getInstance(boolean moveState) {
            TestMoveStrategy.moveState = moveState;
            return testMoveStrategy;
        }

        @Override
        public boolean isMovable() {
            return moveState;
        }
    }
}