package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(value = MethodOrderer.MethodName.class)
class MyNumberScannerTest {

    private ByteArrayInputStream inputStream;

    @Test
    void aaa_readInput_정수() {
        String input = "1\n";

        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThat(MyNumberScanner.readInput()).isEqualTo(1);
    }

    @Test
    void readInput_문자() {
        String input = "a\n";

        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(MyNumberScanner::readInput)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void readInput_음수() {
        String input = "-1351\n";

        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(MyNumberScanner::readInput)
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @EmptySource
    void readInput_Empty(String input) {
        // Null 입력은 불가능하므로 생략
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(MyNumberScanner::readInput)
                .isInstanceOf(RuntimeException.class);
    }

}