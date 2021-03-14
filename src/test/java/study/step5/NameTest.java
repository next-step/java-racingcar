package study.step5;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("빈값 테스트")
    void validEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("");
        }).withMessage("공백으로 자동차 이름을 등록할 수 없습니다.");
    }

    @Test
    @DisplayName("5글자 초과 테스트")
    void validLength() {
        assertThatIllegalArgumentException().isThrownBy(()->{
            new Name("test123");
        }).withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }


}
