package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 기록 관련 클래스 테스트
 */
class RecordTest {

    private static Stream<Arguments> recordParam() {
        return Stream.of(
                Arguments.of(1, 1, true),
                Arguments.of(3, 3, true),
                Arguments.of(2, 1, false),
                Arguments.of(2, 4, false)
        );
    }

    @DisplayName("Record 클래스의 빌더 패턴 테스트")
    @ParameterizedTest(name = "기본 Position :: 기댓값 Position =  {0} :: {1} -> {2}")
    @MethodSource(value = "recordParam")
    void record_ReturnPosition(int recordPosition, int expectedPosition, boolean expected) {
        // given
        Record build = new Record.Builder()
                .position(recordPosition)
                .build();
        // when
        int position = build.getPosition();
        // then
        assertThat(position == expectedPosition).isEqualTo(expected);
    }
}
