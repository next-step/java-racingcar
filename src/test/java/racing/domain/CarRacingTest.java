package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarRacingTest {

    @Test
    @DisplayName("주어진 횟수 만큼 레이싱")
    void testRaceComplete() {
        // given
        int raceCount = 5;
        AtomicInteger count = new AtomicInteger();
        Cars cars = new Cars("pobi,crong,honux");
        CarRacing racing = new CarRacing(cars, new RandomMoveStrategy(0, 9), raceCount);
        // when
        racing.race(dist -> {}, count::getAndIncrement);
        // then
        assertThat(count.get()).isEqualTo(raceCount);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0 })
    @DisplayName("레이스 숫자 1 미만 시 예외 발생")
    void testCountOfRaceLessThanOneThrowException(int countOfRace) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars cars = new Cars("pobi,crong,honux");
            new CarRacing(cars, countOfRace);
        });
    }
}
