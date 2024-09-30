package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositivesTest {

    @Test
    @DisplayName("더하기")
    public void sum() {
        String[] input = {"1", "4", "7", "800"};
        Positives positives = new Positives(input);
        assertThat(positives.sum()).isEqualTo(812);
    }

    @Test
    @DisplayName("양수")
    public void positive() {
        String[] input = {"1"};
        Positives positives = new Positives(input);
        assertThat(positives.sum()).isEqualTo(1);
    }


    @Test
    @DisplayName("숫자가 아닌 문자")
    public void nonNumber() {
        String[] input = {"1", "a", "3"};
        assertThatThrownBy(() -> new Positives((input)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageEndingWith("숫자가 아닙니다.");
    }

    @Test
    @DisplayName("음수")
    public void negative() {
        String[] input = {"1", "-2", "3"};
        assertThatThrownBy(() -> new Positives((input)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageEndingWith("숫자가 아닙니다.");
    }

}
