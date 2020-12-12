package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    public void newNameValidate() {
        // given
        String car1 = "car1";

        // when
        Name name = new Name(car1);

        // then
        assertThat(name.getName()).isEqualTo(car1);
    }

    @Test
    @DisplayName("이름이 5글자가 넘는 경우 오류 발생")
    public void newNameValidateLengthOverOccurredException() {
        assertThatThrownBy(() -> {
            new Name("이름이 5글자가 넘음");
        });
    }
}