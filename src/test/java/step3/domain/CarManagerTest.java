package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.move.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 관리 클래스 테스트
 */
class CarManagerTest {

    public static final MoveStrategy MOVE_STRATEGY = () -> true;

    private static Stream<Arguments> getCarManagement() {
        return Stream.of(
                Arguments.of(new CarManager(3), 3),
                Arguments.of(new CarManager(4), 4)
        );
    }

    @DisplayName("자동차 관리 클래스의 자동차 생성 테스트")
    @ParameterizedTest(name = "CarManage 클래스로 Car 생성된 인스턴스 갯수: {1}")
    @MethodSource("getCarManagement")
    void createCarManageTest(CarManager given, int carSize) {
        // given

        // when
        List<Car> cars = given.getCars();
        // then
        assertThat(cars.size()).isEqualTo(carSize);
    }

    @DisplayName("자동차 라운드별 run 수행 후 RacingRound 값 테스트")
    @ParameterizedTest(name = "레이싱 참여자 {0} 명, 한 라운드 실행한 자동차 수 {1}")
    @CsvSource(value = {"3, 3", "4, 4"})
    void carManager_RunningCarsTest(int participants, int expected) {
        // given
        CarManager carManager = new CarManager(participants, MOVE_STRATEGY);

        // when
        RacingRound run = carManager.run();
        List<Car> cars = run.getCars();
        int racingResult = cars.size();

        // then
        assertThat(racingResult).isEqualTo(expected);
    }

    @DisplayName("한 라운드 레이싱 후 결과 RacingRound의 자동차 위치 확인 테스트")
    @ParameterizedTest(name = "레이싱 참여자 {0} 명, 한 라운드 실행한 자동차 수 {1}")
    @CsvSource(value = {"3, 1", "4, 1"})
    void carManager_moveCarTest(int participants, int expected) {
        // given
        CarManager carManager = new CarManager(participants, MOVE_STRATEGY);
        // when
        RacingRound run = carManager.run();
        List<Car> cars = run.getCars();
        List<Integer> collect = cars.stream()
                .mapToInt(Car::getPosition).boxed()
                .collect(Collectors.toList());

        // then
        collect.forEach(integer -> assertThat(integer).isEqualTo(expected));
    }
}
