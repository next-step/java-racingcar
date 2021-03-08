package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 레이싱 라운드 별 기록 저장 테스트
 */
class RacingRoundTest {

    private List<Car> cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car(1);
        Car car2 = new Car(4);
        Car car3 = new Car(3);

        cars = Arrays.asList(car1, car2, car3);
    }

    @DisplayName("레이싱 라운드 기록 테스트")
    @Test
    void testCase1() {
        // given
        RacingRound racingRound = new RacingRound(cars);
        // when
        int size = racingRound.getCars().size();
        // then
        assertThat(size).isEqualTo(3);
    }
}
