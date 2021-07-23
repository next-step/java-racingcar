package study.step3;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundManagerTest {

    RoundManager roundManager = new RoundManager();

    @Test
    @DisplayName("round 값이 0보다 작거나 같은 경우")
    public void lteZeroRound() {
        // given
        int round = -1;
        List<Runnable> toDoList = Collections.singletonList(() -> System.out.println("lteZeroRound"));
        String message = RoundManager.LESS_THAN_OR_EQUAL_ZERO + round;

        // when
        ThrowingCallable throwingCallable = () -> roundManager.startRace(round, toDoList);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("toDoList 가 null 인 경우")
    public void nullToDoList() {
        // given
        int round = 3;
        List<Runnable> toDoList = null;
        String message = RoundManager.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> roundManager.startRace(round, toDoList);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "toDoList 가 매 라운드마다 실행 되었는지 확인 | {arguments}")
    @CsvSource(value = {"1:1", "3:3", "10:10"}, delimiter = ':')
    public void toDoListValidation(int round, int expected) {
        // given
        AtomicInteger index = new AtomicInteger();
        List<Runnable> toDoList = Collections.singletonList(index::getAndIncrement);

        // when
        roundManager.startRace(round, toDoList);

        // then
        assertThat(index.get()).isEqualTo(expected);
    }

}
