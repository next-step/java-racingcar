package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @DisplayName("입력값 만큼 - 가 표기 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "3:---", "5:-----"}, delimiter = ':')
    public void drawDash(int param1, String expect) throws Exception {
        //given
        //when
        String s = ResultView.drawDash(param1);

        //then
        assertThat(s).isEqualTo(expect);
    }
}