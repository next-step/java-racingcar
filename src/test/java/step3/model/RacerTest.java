package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class RacerTest {

    @DisplayName("경기횟수만큼 경기결과가 생성된다")
    @Test
    public void 경기횟수검증() {
        //given
        int iterations = 5;
        //when
        Racer racer = new Racer(iterations);
        //then
        assertThat(racer.getResults()).hasSize(iterations);
    }

    @DisplayName("경기횟수는 1이상의 양수가 아닐시 예외를 발생시킨다")
    @Test
    public void 경기횟수양수() {
        int iterations = -1;
        //when
        //then
        assertThatThrownBy(() -> {
            Racer racer = new Racer(iterations);
        }).isInstanceOf(RuntimeException.class);
    }

}