package camp.nextstep.edu.nextstep8.racing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameInputTest {
    @DisplayName("시도할 회수 입력시 숫자가 아닌 값이 입력 됐을 경우 IllegalArgumentException 발생")
    @Test
    @Disabled
    public void getRoundTimesThrownTest(){
        // given
        simulateSystemInputStream("ABCDE");

        // when
        RacingGameInput racingGameInput = new RacingGameInput();

        // then
        assertThatThrownBy(()->{
            racingGameInput.getRoundTimes();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해 주세요");
    }

    @DisplayName("시도할 회수 정상 입력시 숫자값 반환")
    @Test
    public void getRoundTimesTest(){
        // given
        String roundTimesString = "5";
        simulateSystemInputStream(roundTimesString);

        // when
        RacingGameInput racingGameInput = new RacingGameInput();
        int roundTimes = racingGameInput.getRoundTimes();

        // then
        assertThat(roundTimes).isEqualTo(Integer.parseInt(roundTimesString));
    }

    @DisplayName("경주할 자동자 이름이 없을 경우 IllegalArgumentException 발생")
    @Test
    public void getCarsThrownTest() {
        // given
        simulateSystemInputStream("");

        // when
        RacingGameInput racingGameInput = new RacingGameInput();

        assertThatThrownBy(() -> {
            racingGameInput.getCars();
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력된 자동자 이름이 없습니다");
    }

    private InputStream simulateSystemInputStream(String input){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return stdin;
    }
}