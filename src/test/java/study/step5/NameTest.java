package study.step5;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step5.domain.Name;

public class NameTest {
    @Test
    @DisplayName("Name 클래스 생성 테스트")
    void create() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }
}
