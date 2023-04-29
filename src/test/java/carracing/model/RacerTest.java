package carracing.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacerTest {
    private static final String EXCEPTION_MESSAGE_FIXTURE = "자동차 이름의 길이는 5를 초과할 수 없습니다";

    @DisplayName("자동차 이름은 5자를 초과할수 없다")
    @Test
    public void limitNameLength5() {
        //given
        String input = "123456";
        //when
        //then
        assertThatThrownBy(() -> {
            new Racer(input, List.of(1));
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(EXCEPTION_MESSAGE_FIXTURE);
    }

    @DisplayName("자동차에 이름을 부여할 수 있다")
    @Test
    public void assignName() {
        //given
        String input = "Tesla";
        //when
        Racer racer = new Racer(input, List.of(1));
        //then
        assertThat(racer.carName()).isEqualTo(input);
    }

    @Disabled
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다")
    @Test
    public void canStopOrGo() {
        //테스트하기 애매모호함 : 입력에 대한 출력 데이터가 명확해야 테스트가능함
    }

    @DisplayName("입력한 이동 시도횟수 만큼 자동차가 이동을 시도한다 : 4이하시 정지")
    @Test
    public void stop() {
        //given
        int input = 4;
        int answer = 0;
        //when
        Racer racer = new Racer("dong", List.of(input));
        //then
        assertThat(racer.finalPosition()).isEqualTo(answer);
    }

    @DisplayName("입력한 이동 시도횟수 만큼 자동차가 이동을 시도한다 : 4초과시 전진")
    @Test
    public void go() {
        //given
        int input = 5;
        int answer = 1;
        //when
        Racer racer = new Racer("dong", List.of(input));
        //then
        assertThat(racer.finalPosition()).isEqualTo(answer);
    }
}