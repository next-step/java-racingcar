package step3and4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PositiveTest {

    @DisplayName("양수가 아니면 예외를 던진다.")
    @Test
    void create() {
        Assertions.assertThatThrownBy(()-> new Positive(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
