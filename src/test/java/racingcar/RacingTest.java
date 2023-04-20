package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    private static final int NUMBER_OF_MOVES = 1;
    private static final int NUMBER_OF_CARS = 3;

    @Test
    @DisplayName("[요구사항 1] 1회 이동 확인")
    void 요구사항_1() {
        // given : 자동차 생성
        Racing racing = new Racing(NUMBER_OF_CARS, NUMBER_OF_MOVES);
        List<Car> cars = Racing.create(NUMBER_OF_CARS);

        // when : 1회 이동 진행
        racing.race(cars);

        // then : TODO: 검증 방법
    }
}