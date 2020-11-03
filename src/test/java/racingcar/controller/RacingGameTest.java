package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import racingcar.domain.car.Cars;
import racingcar.domain.exception.InvalidTryCountException;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.io.PrintWriter;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("게임 테스트")
public class RacingGameTest {

    PrintWriter output = mock(PrintWriter.class);
    InputView inputView = mock(InputView.class);
    ResultView resultView = mock(ResultView.class);

    @BeforeEach
    void setUp() {
        doNothing().when(output).close();
        when(inputView.getCarNames()).thenReturn(Collections.singletonList("a"));
        doNothing().when(resultView).showResultHeader();
        doNothing().when(resultView).showAtStep(anyList());
        doNothing().when(resultView).showWinner(any());
    }

    @DisplayName("주어진 횟수동안 n대의 자동차는 움직일 수 있는 기회를 받음")
    @Test
    public void simulateCarMovement() {
        int tryCount = 3;
        when(inputView.getTryCountFromInput()).thenReturn(tryCount);

        try (MockedStatic<Cars> mocked = mockStatic(Cars.class)) {
            Cars cars = mock(Cars.class);
            mocked.when(() -> Cars.ofNames(anyList())).thenReturn(cars);

            RacingGame.execute(output, inputView, resultView);

            verify(cars, times(tryCount)).move(any());
        }
    }

    @DisplayName("주어진 횟수가 0이하 일때")
    @ParameterizedTest
    @CsvSource(value = {"-1", "0"})
    public void simulateWithTryCount(Integer tryCount) {
        when(inputView.getTryCountFromInput()).thenReturn(tryCount);
        
        try (MockedStatic<Cars> mocked = mockStatic(Cars.class)) {
            Cars cars = mock(Cars.class);
            mocked.when(() -> Cars.ofNames(anyList())).thenReturn(cars);

            assertThatThrownBy(() -> {
                RacingGame.execute(output, inputView, resultView);
            }).isInstanceOf(InvalidTryCountException.class)
                    .hasMessageContaining("invalid try count");
        }

    }
}