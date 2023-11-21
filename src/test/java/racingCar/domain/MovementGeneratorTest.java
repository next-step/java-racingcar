package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MovementGeneratorTest {
    @DisplayName("랜덤 숫자가 4이상인 경우만 이동한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, false", "4, true"})
    void generate(int randomNumber, boolean isMovable) {
        // given
        NumberGenerator numberGenerator = () -> randomNumber;
        MovementGenerator movementGenerator = new MovementGenerator(numberGenerator);

        // when & then
        assertThat(movementGenerator.generate()).isEqualTo(isMovable);
    }
}
