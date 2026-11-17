package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionFormatterTest {
    @ParameterizedTest
    @CsvSource(value = {"0, ''", "1, '-'", "3, '---'"})
    @DisplayName("각 차의 위치를 - 기호로 변환한다")
    void formatPositionToDash(int position, String expected) {
        String result = PositionFormatter.format(position);

        assertThat(result).isEqualTo(expected);
    }
}
