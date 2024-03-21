package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    @Test
    @DisplayName("주어진 이동량만큼 위치를 이동한다.")
    void increase_Amount_PlusPosition() {
        final int startPositionValue = 0;
        final int amount = 2;
        final Position actualPosition = new Position(startPositionValue);
        final Position expectedPosition = new Position(startPositionValue + amount);

        actualPosition.increase(amount);

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("위치 객체 복사 시 참조 값이 다른 동등한 객체를 생성한다.")
    void copyOf_SamePositionValue_Position() {
        final Position originPosition = new Position(0);
        final Position copiedPosition = originPosition.copyOf();

        assertThat(originPosition)
                .isNotSameAs(copiedPosition)
                .isEqualTo(copiedPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("위치의 정수 리터럴을 기준으로 동등성을 판단한다.")
    void equals_PositionValue_TrueOrFalse(final int originValue, final int targetValue, final boolean isEqualPosition) {
        final Position originPosition = new Position(originValue);
        final Position targetPosition = new Position(targetValue);

        assertThat(originPosition.equals(targetPosition))
                .isEqualTo(isEqualPosition);
    }

    @Test
    @DisplayName("위치의 정수 리터럴이 크면 위치도 크다고 판단한다.")
    void compareTo_Position_Bigger() {
        assertThat(new Position(2)).isGreaterThan(new Position(1));
    }

    @Test
    @DisplayName("위치의 정수 리터럴이 같으면 위치도 같다고 판단한다.")
    void compareTo_Position_Same() {
        assertThat(new Position(1)).isEqualByComparingTo(new Position(1));
    }

    @Test
    @DisplayName("위치의 정수 리터럴이 작으면 위치도 작다고 판단한다.")
    void compareTo_Position_Smaller() {
        assertThat(new Position(1)).isLessThan(new Position(2));
    }
}
