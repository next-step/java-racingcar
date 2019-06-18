package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NamesTest {

    @Test
    void createNames() {
        String nameText = "test1,test2,test3";
        assertThat(Names.from(nameText)).isNotNull();
    }

    @Test
    @DisplayName("잘못된 문자열 입력으로 실패")
    void createOfStringFail() {
        String nameText = "test|test2$test3";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Names.from(nameText));
    }
}