package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.ResultView;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {
    @Test
    void 자동차_대수가_0대일때() {
        Cars cars = Cars.builder()
                .carCount(0)
                .raceCondition(new RaceCondition())
                .build();
        assertThatThrownBy(() -> new Race(new ResultView()).start(cars, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    void 주어진_횟수만큼_레이스가_진행되는지(int tryCount) throws InterruptedException {
        int carCount = 3;
        ResultView resultView = mock(ResultView.class);
        Cars cars = Cars.builder()
                .carCount(carCount)
                .raceCondition(new RaceCondition())
                .build();
        new Race(resultView).start(cars, tryCount);

        verify(resultView,times(tryCount)).printCarsMoveState(cars);
    }
}