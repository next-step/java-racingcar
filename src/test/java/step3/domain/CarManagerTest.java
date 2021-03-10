package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.move.MoveStrategy;

import java.util.Arrays;
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
                Arguments.of(new String[]{"a", "b", "c"}, 3),
                Arguments.of(new String[]{"a", "b", "c", "d"}, 4)
        );
    }

    private static Stream<Arguments> racingCarList() {
        return Stream.of(
                Arguments.of(new String[]{"a", "b", "c"}, 1),
                Arguments.of(new String[]{"a", "b", "c", "d"}, 1)
        );
    }

    @DisplayName("자동차 관리 클래스의 자동차 생성 테스트")
    @ParameterizedTest(name = "CarManage 클래스로 Car 생성된 인스턴스 갯수: {1}")
    @MethodSource("getCarManagement")
    void createCarManageTest(String[] participants, int expected) {
        // participants
        CarManager carManager = new CarManager(participants, MOVE_STRATEGY);
        // when
        List<Car> cars = carManager.getCars();
        // then
        assertThat(cars.size()).isEqualTo(expected);
    }

    @DisplayName("자동차 라운드별 run 수행 후 RacingRound 값 테스트")
    @ParameterizedTest(name = "레이싱 참여자 entry {0}, 한 라운드 실행한 자동차 수 {1}")
    @MethodSource("getCarManagement")
    void carManager_RunningCarsTest(String[] participants, int expected) {
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
    @ParameterizedTest(name = "레이싱 참여자 entry {0}, 한 번 라운드 진행 한 위치 정보 {1}")
    @MethodSource("racingCarList")
    void carManager_moveCarTest(String[] participants, int expected) {
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
