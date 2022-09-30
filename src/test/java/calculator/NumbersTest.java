package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("여러 숫자를 더한 값을 반환한다.")
    void sum_numbers() {
        List<Number> numbers = new ArrayList<>();
        Collections.addAll(numbers, new Number(1), new Number(2), new Number(3));
        assertThat(new Numbers(numbers).sum()).isEqualTo(new Number(6));
    }
}
