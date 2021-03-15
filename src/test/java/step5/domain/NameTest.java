package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @DisplayName("name 생성자 테스트 - 이름이 정상적일 경우 ")
    @ParameterizedTest
    @ValueSource(strings = {"aaa","bbb","ccc","ddd"})
    void nameTest(String string) {
        Name name = new Name(string);
        assertEquals(name.getName(), string);
    }

    @DisplayName("name 생성자 테스트 - 이름이 비었을 경우")
    @Test
    void nameEmptyTest() {
        assertThrows(IllegalArgumentException.class, () -> new Name(""));
    }

    @DisplayName("name 생성자 테스트 - 이름이 5자 이상일 경우")
    @Test
    void nameOverSizeTest() {
        assertThrows(IllegalArgumentException.class, () -> new Name("11111"));
    }

}