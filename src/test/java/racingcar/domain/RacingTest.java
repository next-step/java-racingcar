package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.domain.exception.AlreadyRaceFinishedException;
import racingcar.view.Watcher;

class RacingTest {
    private Watcher watcher;

    @BeforeEach
    void setUp() {
        watcher = new Watcher(new Consumer<List<Distance>>() {
            @Override
            public void accept(List<Distance> distances) {}
        });
    }

    @DisplayName("자동차 대수나 시도 횟수가 유효하다면 Racing 객체를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "1,1", "2,1", "1,2", "10,9" }, delimiter = ',')
    void of(int carCount, int tryCount) {
        assertThat(Racing.of(carCount, tryCount)).isNotNull().isInstanceOf(Racing.class);
    }
    
    @DisplayName("자동차 대수나 시도 횟수가 유효하지 않으면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = { "0,1", "-1,1", "1,0", "0,0" }, delimiter = ',')
    void of_when_invalid_count(int carCount, int tryCount) {
        assertThatThrownBy(() -> {
            Racing.of(carCount, tryCount);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("Number of cars is greater than 0 and trial count must be greater than or equal to 1.");
    }

    @DisplayName("현재 시도 횟수가 최대 재시도 횟수보다 적다면 false 를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = { "1,2", "0,3" }, delimiter = ',')
    void finish(int currentTryCount, int tryCount) {
        Racing racing = Racing.of(2, tryCount);
        race(racing, currentTryCount);
        assertThat(racing.isFinish()).isFalse();
    }

    @DisplayName("시도 횟수보다 더 많이 시도하면 AlreadyRaceFinishedException 예외를 발생시킨다.")
    @Test
    void race_when_occured_exception() {
        int tryCount = 3;
        Racing racing = Racing.of(2, tryCount);
        
        assertThatThrownBy(() -> {
            race(racing, tryCount + 1);
        }).isInstanceOf(AlreadyRaceFinishedException.class).hasMessageMatching("The race has already ended.");
    }

    private void race(Racing racing, int maxRetryCount) {
        for (int count = 0; count < maxRetryCount; count++) {
            racing.race(watcher);
        }
    }
}
