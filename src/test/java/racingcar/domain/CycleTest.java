package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CycleTest {
    @DisplayName("사용자는 자동차 게임 시도 횟수를 입력할 수 있다.")
    @Test
    public void inputCycleTest(){
        Cycle cycle = new Cycle(3);
        assertThat(cycle).isInstanceOf(Cycle.class);
    }

    @DisplayName("자동차 게임 시도 횟수가 0일 때 예외를 발생시킨다.")
    @Test
    public void inputZeroCycleTest(){
        assertThrows(IllegalArgumentException.class, () -> new Cycle(0));
    }

    @DisplayName("자동차 게임 시도 횟수가 음수일 때 예외를 발생시킨다.")
    @Test
    public void inputMinusCycleTest(){
        assertThrows(IllegalArgumentException.class, () -> new Cycle(-1));
    }
}
