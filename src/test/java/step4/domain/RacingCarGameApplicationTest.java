package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameApplicationTest {

    @DisplayName("RacingCarGameApplication 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        RacingCarGameApplication application = new RacingCarGameApplication();

        // when
        assertThat(application).isNotNull();
    }

}