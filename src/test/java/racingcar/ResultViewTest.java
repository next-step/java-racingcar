package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    @DisplayName("위치에 맞는 출력")
    void resultPathTest() {
        assertThat(ResultView.getPathString(3)).isEqualTo("---");
    }

    @Test
    @DisplayName("이름과 위치에 맞는 출력")
    void roundResult() {
        assertThat(ResultView.getRoundResultStr("pobi", 3)).isEqualTo("pobi : ---");
    }

    @Test
    @DisplayName("우승자 이름 출력")
    void getWinnerManyMessage() {
        List<String> carNameList = Arrays.asList("yuno", "bingb");
        assertThat(ResultView.getWinnerMessage(carNameList)).isEqualTo("yuno, bingb가 최종 우승했습니다.");
    }

    @Test
    @DisplayName("우승자 이름 출력")
    void getWinnerOneMessage() {
        List<String> carNameList = Arrays.asList("yuno");
        assertThat(ResultView.getWinnerMessage(carNameList)).isEqualTo("yuno가 최종 우승했습니다.");
    }
}
