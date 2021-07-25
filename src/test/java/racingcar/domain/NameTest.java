package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi", "crong", "hounx"}, delimiter = ':')
    @DisplayName("이름이 잘 생성 되는가")
    void create(final String name) {
        assertDoesNotThrow(() -> Name.from(name));
    }

    @ParameterizedTest
    @CsvSource(value = {"aaaaaa", "bbbbbbb", "cccccccc"}, delimiter = ':')
    @DisplayName("5글자 초과하면 이름이 만들어지지 않음")
    void overLength(final String name) {
        assertThrows(IllegalArgumentException.class, () -> Name.from(name));
    }
}