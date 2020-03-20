package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalcTest {

    int before;
    int after;

    @BeforeEach
    void setUp() {
       before = 3;
       after = 2;
    }

    @Test
    void plus() {
        assertThat(before + after).isEqualTo(5);
    }

    @Test
    void minus() {
        assertThat(before - after).isEqualTo(1);
    }

    @Test
    void multiplication() {
        assertThat(before * after).isEqualTo(6);
    }

    @Test
    void division() {
        assertThat(before / after).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "test"})
    void isBlank(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    if (!value.trim().isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "?:false"}, delimiter = ':')
    void isOperator(String operator, boolean expected) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                        throw new IllegalArgumentException();
                    }
                });
    }



}
