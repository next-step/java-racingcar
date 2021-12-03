package study.racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Name;

class InputViewTest {
    @Test
    @DisplayName("String 을 List<Name>으로 변경")
    void convertNames() {
        List<Name> names = InputView.stringIntoNames("a,b,c");
        assertThat(names).contains(new Name("a"), new Name("b"), new Name("c"));
    }

    @Test
    @DisplayName("문자열이 공백이 들어간 경우")
    void nullCheckConvertNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    List<Name> names = InputView.stringIntoNames("  ");
                });
    }
}