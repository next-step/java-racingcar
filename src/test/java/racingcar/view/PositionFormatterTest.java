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
        PositionFormatter positionFormatter = new PositionFormatter();

        String output = positionFormatter.format(position);

        assertThat(output).isEqualTo(expected);
    }
}
