package carracing.present;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputPresentTest {

    private InputPresent inputPresent;

    @AfterEach
    public void afterEach() {
        System.setIn(System.in);
    }

    private void setInputString(String inputString) {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        this.inputPresent = new InputPresent();
    }

    @DisplayName("자동차 이름을 입력받을떄, 쉼표를 기준으로 구분한다")
    @Test
    public void commaSeparated() {
        //given
        String input = "pobi,crong,honux";
        setInputString(input);
        //when
        List<String> participates = inputPresent.participates();
        //then
        assertThat(String.join(",", participates)).isEqualTo(input);
    }

    @DisplayName("입력한 이름 수 만큼 자동차가 경주에 참여한다")
    @Test
    public void iteration() {
        //given
        String input = "Feynman,Tesla,Faraday,Maxwell";
        int answer = 4;
        setInputString(input);
        //when
        List<String> participates = inputPresent.participates();
        //then;
        assertThat(participates).hasSize(answer);
    }
}