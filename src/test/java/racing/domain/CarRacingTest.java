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
        CarRacing racing = new CarRacing("pobi,crong,honux", new RandomMoveStrategy(0, 9), raceCount);
        // when
        racing.race(dist -> {}, count::getAndIncrement);
        // then
        assertThat(count.get()).isEqualTo(raceCount);
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0 })
    @DisplayName("레이스 숫자 1 미만 시 예외 발생")
    void testCountOfRaceLessThanOneThrowException(int countOfRace) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CarRacing("pobi,crong,honux", countOfRace));
    }

    @Test
    @DisplayName("레이스 종료 후 우승자 확인")
    void testRacingWinners() {
        // given
        String[] names = {"pobi", "crong", "honux"};
        CarRacing racing = new CarRacing(String.join(",", names), () -> true, 5);
        // when
        racing.race(carContext -> {}, () -> {});
        // when
        assertThat(racing.getWinnerCarNames()).isEqualTo(names);
    }
}
