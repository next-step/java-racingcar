package step4.domain.car.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("Name 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String testName = "test";

        // when
        Name name = new Name(testName);

        // then
        assertThat(name).isNotNull();
    }

    @DisplayName("Name 인스턴스의 부적절한 이름시 예외처리 확인 테스트")
    @Test
    void 검증() {
        // given
        String invalidName = "kwj1270";

        // when and then
        assertThatThrownBy(() -> {
            new Name(invalidName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 이름을 사용했습니다.");

    }
}