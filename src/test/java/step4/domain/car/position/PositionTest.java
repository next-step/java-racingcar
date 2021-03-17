package step4.domain.car.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("Position 인스턴스 생성 여부 테스트")
    @Test
    void 생성(){
        // given and when
        Position position = new Position();

        // then
        assertThat(position).isNotNull();
    }
}