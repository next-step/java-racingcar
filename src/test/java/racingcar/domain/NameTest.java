package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    @DisplayName("Name 클래스 생성 테스트")
    void create() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    @DisplayName("이름 exception over 5 length")
    void nameOver5Exception() {
        assertThatThrownBy(() -> {
            new Name("crongg");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력 조건을 만족하지 않습니다.");
    }

    @Test
    @DisplayName("이름 exception empty")
    void nameEmptyException() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력 조건을 만족하지 않습니다.");
    }
}
