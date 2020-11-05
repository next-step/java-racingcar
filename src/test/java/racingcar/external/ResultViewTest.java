package racingcar.external;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private ResultView resultView;

    @BeforeEach
    public void setup() {
        resultView = new ResultView();
    }

    @DisplayName("getMoveDash() 테스트")
    @ParameterizedTest(name = "[{index}] position이 {0} 일때, 결과값 : {1}")
    @CsvSource(value = {
            "1, -",
            "2, --",
            "3, ---",
            "7, -------"
    })
    void getMoveDash(int position, String expectedResult) {
        String result = resultView.getMoveDash(position);

        assertThat(result).isEqualTo(expectedResult);
    }
}
