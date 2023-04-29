package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    private static final String[] RACING_CAR_EXAMPLE = new String[]{"pobi", "crong", "honux"};
    private static final int ONE = 1;

    @Test
    @DisplayName("[요구사항 1] 1회 이동 확인")
    void 요구사항_1() {
        // given : 자동차 생성 및 강제 1회 이동
        List<Car> cars = Racing.create(RACING_CAR_EXAMPLE);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        ForceMovingStrategy forceMovingStrategy = new ForceMovingStrategy(randomNumberGenerator);
        Racing racing = new Racing(RACING_CAR_EXAMPLE, cars, forceMovingStrategy);
        racing.race();

        // then : 모든 차들이 1칸을 갔는지 검증
        cars.forEach(car -> assertThat(car.getMoveCount()).isEqualTo(ONE));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("[요구사항 2] 강제 1회 이동 후 최종 우승자 출력 확인")
    void 요구사항_2(String carName) {
        // given : 자동차 생성 및 강제 1회 이동
        List<Car> cars = Racing.create(RACING_CAR_EXAMPLE);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        ForceMovingStrategy forceMovingStrategy = new ForceMovingStrategy(randomNumberGenerator);
        Racing racing = new Racing(RACING_CAR_EXAMPLE, cars, forceMovingStrategy);
        racing.race();

        // when : 최대 이동 횟수 찾고, 우승자들 리스트 찾기
        int maxMoveCount = racing.findMaxMoveCount(cars);
        List<String> winners = racing.findWinnerCarNames(cars, maxMoveCount);

        // then : 최종 우승자가 pobi, crong, honux 모두 나오는지 검증
        assertThat(winners.contains(carName)).isTrue();
    }
}