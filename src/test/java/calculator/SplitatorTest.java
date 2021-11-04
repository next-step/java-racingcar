package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SplitatorTest {

    @Test
    void splitOperation() {
        Spliterator spliterator = new Spliterator("1 + 3");

        assertThat(spliterator.next()).isEqualTo(new Num(1));
        assertThat(spliterator.next()).isEqualTo(Operator.of("+"));
        assertThat(spliterator.next()).isEqualTo(new Num(3));
    }
}
