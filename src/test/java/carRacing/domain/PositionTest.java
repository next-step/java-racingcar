package carRacing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차위치 VO 관련 테스트")
public class PositionTest {
    @Test
    @DisplayName("자동차 위치 변경시 새로운 vo 객체 생성 확인")
    void 자동차위치_확인() {
        Position position = new Position(0);
        Position movePosition = position.move();
        boolean result = movePosition.isSame(1);

        Assertions.assertThat(result).isTrue();

    }
}
