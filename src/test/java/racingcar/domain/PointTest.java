package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Point 객체 테스트")
public class PointTest {

    @DisplayName("현재 포인트에서 포인트를 더하라고 요청하면 1점이 늘어난다")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3", "7:8"}, delimiter = ':')
    void 포인트_증가_요청을_하면_포인트가_1_늘어난다(int number, int expected) {
        Point point = new Point(number);
        point.plusPoint();
        int actual = point.getPoint();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
