package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Fuel 테스트")
class FuelTest {

    @DisplayName("랜덤 값이 4보다 클 경우 true 를 반환")
    @Test
    void isMovable_isRandomNumberGreaterThanEqualsToFour_True() {
        // Given
        Fuel fuel = new Fuel();

        // When
        boolean isOverFour = fuel.isMovable();

        // Then
        assertThat(isOverFour);
    }

    // TODO : Random 테스트
}