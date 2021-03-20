package step4.domain.car.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("Position 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given and when
        Position actualPosition = new Position();
        Position expectedPosition = new Position();

        // then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("Position 인스턴스 증가 여부 테스트")
    @Test
    void 증가() {
        // given
        Position actualPosition = new Position();
        Position expectedPosition = new Position(1);

        // when
        actualPosition.increase();

        // then
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("Position 인스턴스 비교시 더 큰 인스턴스 반환 테스트")
    @Test
    void 비교() {
        Position standardPosition = new Position();
        Position expectedPosition = new Position(1);

        Position actualPosition = standardPosition.getWinningPosition(expectedPosition);
        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

}