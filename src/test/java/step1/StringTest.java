package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("1,2을 ',' 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void splitTest(String str, String[] expected) {
        String[] actual = str.split(",");

        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> splitTest() {
        return Stream.of(
                Arguments.of(
                        "1,2", new String[]{"1", "2"}
                )
        );
    }


}
