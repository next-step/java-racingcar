package cargameracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void nameLength() {
        assertThatThrownBy(()->{
            new Name("asdbcET");
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없음");
        }).isInstanceOf(Exception.class);
    }
}
