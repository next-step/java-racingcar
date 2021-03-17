package step4.domain.car.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @DisplayName("Name 클래스의 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String testName = "test";

        // when
        Name name = new Name(testName);

        // then
        assertThat(name).isNotNull();
    }
}