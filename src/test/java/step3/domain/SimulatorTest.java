package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("게임 시뮬레이터 테스트")
@ExtendWith(MockitoExtension.class)
public class SimulatorTest {

    @Mock
    GameEnvironment gameEnvironment;

    @DisplayName("주어진 횟수동안 n대의 자동차는 움직일 수 있는 기회를 받음")
    @Test
    public void simulateCarMovement() {
        Integer tryCount = 3;
        Cars cars = mock(Cars.class);
        when(gameEnvironment.getTryCount()).thenReturn(tryCount);
        when(gameEnvironment.getCars()).thenReturn(cars);

        Simulator simulator = new Simulator(gameEnvironment);
        simulator.execute();

        verify(cars, times(tryCount)).move();
    }
}