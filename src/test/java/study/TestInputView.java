package study;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestInputView {
    @ParameterizedTest
    @CsvSource({"자동차 대수는 몇 대 인가요?,3,자동차 대수는 몇 대 인가요?,3",
            "시도할 회수는 몇 회 인가요?,5,시도할 회수는 몇 회 인가요?,5", })
    void test_inputView(String message, int counts, String resultMessage, int resultCounts) {
        InputView carView = new InputView(message);
        carView.setCounts(counts);
        assertThat(carView.getMessage()).isEqualTo(resultMessage);
        assertThat(carView.getCounts()).isEqualTo(resultCounts);
    }
}
