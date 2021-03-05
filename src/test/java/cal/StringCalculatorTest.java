package cal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @DisplayName("\"3 + 5\"는 8을 반환해야 한다.")
    @Test
    void calculateAddition() {
        // Arrange
        String source = "3 + 5";

        // Act
        int result = calculator.calculateStringEquation(source);

        // Assert
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("\"6 - 2\"는 4를 반환해야 한다.")
    @Test
    void calculateSubtraction() {
        // Arrange
        String source = "6 - 2";

        // Act
        int result = calculator.calculateStringEquation(source);

        // Assert
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("\"2 * 3\"는 6을 반환해야 한다.")
    @Test
    void calculateMultiplication() {
        // Arrange
        String source = "2 * 3";

        // Act
        int result = calculator.calculateStringEquation(source);

        // Assert
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("\"8 / 4\"는 2를 반환해야 한다.")
    @Test
    void calculateDivision() {
        // Arrange
        String source = "8 / 4";

        // Act
        int result = calculator.calculateStringEquation(source);

        // Assert
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("입력값이 null이면 IllegalArgumentException을 던져야 한다.")
    @Test
    void calculateNull() {
        // Arrange
        String source = null;

        // Act & Assert
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculateStringEquation(source));
    }

    @DisplayName("입력값이 빈 공백 문자일 경우 IllegalArgumentException을 던져야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void calculateEmptyCharacter(String source) {

        // Act & Assert
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculateStringEquation(source));
    }

    @DisplayName("\"4 + 3 - 2 * 4 / 5\"는 4를 반환해야 한다.")
    @Test
    void calculateEveryOperator() {
        // Arrange
        String source = "4 + 3 - 2 * 4 / 5";

        // Act
        int result = calculator.calculateStringEquation(source);

        // Assert
        assertThat(result).isEqualTo(4);
    }
}