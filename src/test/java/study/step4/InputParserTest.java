package study.step4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @ParameterizedTest(name = "자동차_이름은_쉼표를_기준으로_구분: {0}")
    @CsvSource(value = {
        "그랜져,소나타,K5:3",
        "그랜져, 소나타, K5:3",
        "그랜져,소나타:2",
        "그랜져 , 소나타:2",
        "그랜져:1",
    }, delimiter = ':')
    void 자동차_이름은_쉼표를_기준으로_구분(String carNames, int result) {
        assertThat(InputParser.parse(carNames)).hasSize(result);
    }

}
