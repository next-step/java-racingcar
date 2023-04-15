package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @DisplayName("A 차량이 이긴 경우")
    @ParameterizedTest
    @CsvSource(value = {"16:12", "10:6", "5:0"}, delimiter = ':')
    public void 자동차_점수_비교_A차량_우승(int aScore, int bScore) throws Exception {
        ResultView resultView = new ResultView();

        String winner = resultView.isWinner("A", new Car("A", aScore), new Car("B", bScore));
        assertThat(winner).isEqualTo("A");
    }

    @DisplayName("B 차량이 이긴 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:6", "12:13"}, delimiter = ':')
    public void 자동차_점수_비교_B차량_우승(int aScore, int bScore) throws Exception {
        ResultView resultView = new ResultView();

        String winner = resultView.isWinner("", new Car("A", aScore), new Car("B", bScore));
        assertThat(winner).isEqualTo("B");
    }

    @DisplayName("A, B 차량이 이긴 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "6:6", "13:13"}, delimiter = ':')
    public void 자동차_점수_비교_A_B차량_동점(int aScore, int bScore) throws Exception {
        ResultView resultView = new ResultView();

        String winner = resultView.isWinner("A", new Car("A", aScore), new Car("B", bScore));
        assertThat(winner).isEqualTo("A,B");
    }

}
