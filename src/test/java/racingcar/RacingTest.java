package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    private static final int NUMBER_OF_CARS = 3;

    @Test
    @DisplayName("[요구사항 1] 1회 이동 확인")
    void 요구사항_1() {
        // given : 자동차 생성 및 강제 1회 이동
        List<Car> cars = Racing.create(NUMBER_OF_CARS);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        ForceMovingStrategy forceMovingStrategy = new ForceMovingStrategy(randomNumberGenerator);
        Racing racing = new Racing(NUMBER_OF_CARS, cars, forceMovingStrategy);
        racing.race();

        // then : 모든 차들이 1칸을 갔는지 검증
        cars.forEach(car -> assertThat(car.getMoveCount()).isEqualTo(1));
    }
}