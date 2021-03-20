package step4.domain.car.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("Position 인스턴스 부적절한 값 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        int invalidValue = -1;

        assertThatThrownBy(()-> {
            assertThat(new Position(invalidValue));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");

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